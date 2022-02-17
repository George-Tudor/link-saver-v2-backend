package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.LinkPreviewAPI.LinkPreview;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import com.georgetudor.linksaverv2backend.services.LinkPreviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LinkPreviewService linkPreviewService;

    @PostMapping(value = "/links")
    public void saveLink(@RequestBody Link link, Authentication authentication) {
        link.setUser(userRepository.findByUsername(authentication.getName()));
        LinkPreview linkPreview = linkPreviewService.getLinkInfo(link);
        link.setTitle(linkPreview.getTitle());
        link.setDescription(linkPreview.getDescription());
        link.setImageUrl(linkPreview.getImage());
        link.setUrl(linkPreview.getUrl());
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
