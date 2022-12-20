package com.georgetudor.linksaverv2backend.controllers;

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
    @RequestMapping(value = "/links/{linkId}/add-tag", method = RequestMethod.POST)
    public void addTag(@RequestBody String tag, @PathVariable long linkId) {
        tagService.addTag(tag, linkId);
    }

    @DeleteMapping("/links/{linkId}/delete-tag/{tagId}")
    public void getTags(@PathVariable long linkId, @PathVariable long tagId) {
        tagService.removeTagFromLink(linkId, tagId);
    }

}
