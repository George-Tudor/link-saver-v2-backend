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

    public void addTag(String tag, Long linkId) {
        Link link = linkRepository.findById(linkId).orElseThrow(IllegalStateException::new);
        if (link != null) {
            Tag existingTag = tagRepository.findTagByDescription(tag);
            if (existingTag == null) {
                addNewTag(tag, link);
            } else {
                addExistingTag(existingTag, link);
            }
        }
    }

    public void addNewTag(String tag, Link link) {
        Tag savedTag = new Tag();
        savedTag.setDescription(tag);
        savedTag = tagRepository.save(savedTag);
        addTagToLink(link, savedTag);
    }

    private void addTagToLink(Link link, Tag tag) {
        link.getTags().add(tag);
        linkRepository.save(link);
    }

    public void removeTagFromLink(Long linkId, Long tagId) {
        Link link = linkRepository.findById(linkId).orElseThrow(IllegalStateException::new);
        Tag tag = tagRepository.findById(tagId).orElseThrow(IllegalStateException::new);
        link.getTags().remove(tag);
        linkRepository.save(link);
    }

    private void addExistingTag(Tag tag, Link link) {
        Tag existingLinkTag = null;
        for (Tag t : link.getTags()) {
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
