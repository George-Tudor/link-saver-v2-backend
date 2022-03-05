package com.georgetudor.linksaverv2backend.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@Controller
public class UserController {

    @GetMapping("/me")
    public String whoAmI(Authentication authentication) {
        return authentication.getName();
    }
}
