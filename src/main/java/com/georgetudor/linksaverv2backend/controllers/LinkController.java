package com.georgetudor.linksaverv2backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @PostMapping("/add-link")
    public String addLink() {

        return "add-link";
    }

    @GetMapping("/list-links")
    public String listLinks() {
        return "list-links";
    }

}
