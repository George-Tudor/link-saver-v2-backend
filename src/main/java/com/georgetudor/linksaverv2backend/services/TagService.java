package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.Tag;
import com.georgetudor.linksaverv2backend.models.User;
import com.georgetudor.linksaverv2backend.repository.LinkRepository;
import com.georgetudor.linksaverv2backend.repository.TagRepository;
import com.georgetudor.linksaverv2backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService {
    @Autowired
    private LinkRepository linkRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TagRepository tagRepository;

    public void addTag(Tag tag, String username) {
        User user = userRepository.findByUsername(username);
//        Tag existingTag = tagRepository.findById();
//        if(existingTag == null) {
//
//        }
    }
}
