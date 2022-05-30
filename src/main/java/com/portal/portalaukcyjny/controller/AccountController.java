package com.portal.portalaukcyjny.controller;

import com.portal.portalaukcyjny.entity.User;
import com.portal.portalaukcyjny.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@Controller
@AllArgsConstructor
@RequestMapping(path="/authorization")
public class AccountController {

    AccountService accountService;

    @PostMapping(path="/addUser")
    public @ResponseBody ResponseEntity<String> addNewUser(@RequestBody User user) {
        return accountService.createNewUser(user);
    }

    @GetMapping(path="/getUser")
    public @ResponseBody ResponseEntity<?> getUser(@RequestParam String login, @RequestParam String password) {
        return accountService.validateCredentials(login, password);
    }
}
