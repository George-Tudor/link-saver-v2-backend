package com.georgetudor.linksaverv2backend.services;

import com.georgetudor.linksaverv2backend.models.Link;
import com.georgetudor.linksaverv2backend.models.Tag;
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

    public void addTag(Tag tag, String linkUrl) {
        Link link = linkRepository.findByUrl(linkUrl);
        Tag existingTag = tagRepository.findTagByDescription(tag.getDescription());
        if (existingTag == null) {
            addNewTag(tag, link);
        } else {
            addExistingTag(existingTag, link);
        }
    }

    public void addNewTag(Tag tag, Link link) {
        Tag savedTag = tagRepository.save(tag);
        addTagToLink(link, savedTag);
    }

    private void addTagToLink(Link link, Tag tag) {
        link.getTag().add(tag);
        linkRepository.save(link);
    }

    private void addExistingTag(Tag tag, Link link) {
        Tag existingLinkTag = null;
        for (Tag t : link.getTag()) {
            if (t.getDescription().equals(tag.getDescription())) {
                existingLinkTag = t;
                break;
            }
        }
        if (existingLinkTag == null) {
            addTagToLink(link, tag);
        }
    }
}
