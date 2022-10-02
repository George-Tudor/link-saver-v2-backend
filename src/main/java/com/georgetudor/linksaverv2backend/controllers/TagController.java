package com.georgetudor.linksaverv2backend.controllers;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.Tag;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.TagRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import com.georgetudor.linksaverv2backend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class TagController {

    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    TagService tagService;


    @ResponseBody
    @RequestMapping(value = "/add-tag", method = RequestMethod.POST)
    public void addTag(@RequestBody Tag tag, Link link) {
        String linkUrl = link.getUrl();
        tagService.addTag(tag, linkUrl);
    }

}
