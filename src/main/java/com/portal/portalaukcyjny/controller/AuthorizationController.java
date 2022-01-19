package com.portal.portalaukcyjny.controller;

import com.portal.portalaukcyjny.entity.User;
import com.portal.portalaukcyjny.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@RequestMapping(path="/authorization")
public class AuthorizationController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/addUser")
    public @ResponseBody String addNewUser(@RequestParam String login,
                                           @RequestParam String email,
                                           @RequestParam String password,
                                           @RequestParam String homeNumber,
                                           @RequestParam String streetName,
                                           @RequestParam String cityName,
                                           @RequestParam String postalNumber,
                                           @RequestParam String name,
                                           @RequestParam String surname) {
        User newUser = new User();
        newUser.setLogin(login);
        newUser.setEmail(email);

        newUser.setHomeNumber(homeNumber);
        newUser.setStreetName(streetName);
        newUser.setCityName(cityName);
        newUser.setPostalNumber(postalNumber);
        newUser.setName(name);
        newUser.setSurname(surname);

        String salt = BCrypt.gensalt(10);
        String hashedPassword = BCrypt.hashpw(password, salt);

        newUser.setSalt(salt);
        newUser.setPassword(hashedPassword);
        newUser.setWalletBalance(0f);
        newUser.setRole("user");

        userRepository.save(newUser);
        return "OK";
    }

    @GetMapping(path="/getUser")
    public @ResponseBody User getUser(@RequestParam String login, @RequestParam String password) {
        User myUser = userRepository.findByLogin(login);
        String passedPassword = BCrypt.hashpw(password, myUser.getSalt());
        if(passedPassword.equals(myUser.getPassword())) {
            return myUser;
        }
        return null;
    }
}
