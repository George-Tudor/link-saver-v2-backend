package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.User;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import com.georgetudor.linksaverv2backend.services.OpenGraphService;
import com.georgetudor.linksaverv2backend.services.WebsiteMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;



    @PostMapping(value = "/links")
    public void saveLink(@RequestBody Link link) throws IOException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        link.setUser(userRepository.findByUsername(username));
        try {
            OpenGraphService.getOpenGraphInfo(link);
        } catch (Exception e) {
            e.printStackTrace();
            WebsiteMetadataService.getMetaData(link);
        }
        linkRepository.save(link);
    }


    @GetMapping("/links")
    public Iterable<Link> listLinks() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        long userid = user.getId();
        return linkRepository.findAllByUserId(userid);
    }

    @DeleteMapping("/links/{id}")
    public void deleteLink(@PathVariable Long id) {
        linkRepository.deleteById(id);
    }

}
