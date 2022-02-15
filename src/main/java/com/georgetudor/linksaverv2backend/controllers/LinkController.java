package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.User;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = "/links")
    public void saveLink(@RequestBody Link link, Authentication authentication) {
        link.setUser(userRepository.findByUsername(authentication.getName()));
        linkRepository.save(link);
    }


    @GetMapping("/links")
    public Iterable<Link> listLinks() {
        return linkRepository.findAll();
    }

    @DeleteMapping("/links/{id}")
    public void deleteLink(@PathVariable Integer id) {
        linkRepository.deleteById(id);
    }

}
