//package com.georgetudor.linksaverv2backend.controllers;
//
//import com.georgetudor.linksaverv2backend.models.Tag;
//import com.georgetudor.linksaverv2backend.repository.LinkRepository;
//import com.georgetudor.linksaverv2backend.repository.TagRepository;
//import com.georgetudor.linksaverv2backend.repository.UserRepository;
//import com.github.siyoon210.ogparser4j.OgParser;
//import com.github.siyoon210.ogparser4j.OpenGraph;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin
//public class TagController {
//
//    @Autowired
//    private LinkRepository linkRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TagRepository tagRepository;
//
//    @PostMapping(value = "/tags")
//    public void addTag(@RequestBody Tag tag) {
//        String username = SecurityContextHolder.getContext().getAuthentication().getName();
//        tag.setUser(userRepository.findByUsername(username));
//        OgParser ogParser = new OgParser();
//        OpenGraph openGraph = ogParser.getOpenGraphOf(link.getUrl());
//        OpenGraph.Content image = openGraph.getContentOf("image");
//        link.setImageUrl(image.getValue());
//        OpenGraph.Content description = openGraph.getContentOf("description");
//        link.setDescription(description.getValue());
//        OpenGraph.Content title = openGraph.getContentOf("title");
//        link.setTitle(title.getValue());
//        linkRepository.save(link);
//    }
//}
