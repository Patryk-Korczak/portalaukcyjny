package com.portal.portalaukcyjny.service;

import com.portal.portalaukcyjny.entity.User;
import com.portal.portalaukcyjny.enums.UserType;
import com.portal.portalaukcyjny.repository.UserRepository;
import com.portal.portalaukcyjny.utility.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class AccountService {
    @Autowired
    private UserRepository userRepository;

    public AccountService() {
    }

    public ResponseEntity<String> createNewUser(User user) {
        ResponseEntity<String> response;

        User newUser = new User();
        newUser.setLogin(user.getLogin());
        newUser.setEmail(user.getEmail());

        newUser.setHomeNumber(user.getHomeNumber());
        newUser.setStreetName(user.getStreetName());
        newUser.setCityName(user.getCityName());
        newUser.setPostalNumber(user.getPostalNumber());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        String salt = Utility.generateSalt();
        newUser.setWalletBalance(0.0);
        newUser.setRole(UserType.USER.toString());

        String hashedPassword = Utility.hashPassword(user.getPassword(), salt);
        newUser.setSalt(salt);
        newUser.setPassword(hashedPassword);

        try {
            userRepository.save(newUser);
            response = ResponseEntity.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(Utility.USER_CREATED + newUser.getLogin());
        } catch (Exception e) {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Utility.USER_ALREADY_EXISTS);
        }

        return response;
    }

    public ResponseEntity<?> validateCredentials(String login, String password) {
        ResponseEntity<?> response;
        User myUser = userRepository.findByLogin(login);

        if(myUser.getPassword().equals(Utility.hashPassword(password, myUser.getSalt()))) {
            response = ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(myUser);
        } else {
            response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Utility.INVALID_CREDENTIALS);
        }

        return response;
    }
}
