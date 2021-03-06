package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.User;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import com.github.siyoon210.ogparser4j.OgParser;
import com.github.siyoon210.ogparser4j.OpenGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;



    @PostMapping(value = "/links")
    public void saveLink(@RequestBody Link link) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        link.setUser(userRepository.findByUsername(username));
        OgParser ogParser = new OgParser();
        OpenGraph openGraph = ogParser.getOpenGraphOf(link.getUrl());
        OpenGraph.Content image = openGraph.getContentOf("image");
        link.setImageUrl(image.getValue());
        OpenGraph.Content description = openGraph.getContentOf("description");
        link.setDescription(description.getValue());
        OpenGraph.Content title = openGraph.getContentOf("title");
        link.setTitle(title.getValue());
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
