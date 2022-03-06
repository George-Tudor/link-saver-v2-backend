package com.georgetudor.linksaverv2backend.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class UserController {

    @GetMapping("/me")
    public UserResponse whoAmI(String username) {
        return new UserResponse(username);
    }

    private class UserResponse {
        private String username;

        public UserResponse(String name) {
            this.username = name;
        }

        public String getUsername() {
            return username;
        }
    }
}
