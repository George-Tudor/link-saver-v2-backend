package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private LinkRepository linkRepository;

    @RequestMapping(value = "/add-link", method = RequestMethod.POST)
    public void addLink() {
        public ResponseEntity<?> saveLink(@RequestBody Link link) throws Exception {
            return ResponseEntity.ok(linkRepository.save(link));
        }
    }

    @GetMapping("/list-links")
    public String listLinks() {
        return "list-links";
    }

}
