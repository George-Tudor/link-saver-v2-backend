package com.georgetudor.linksaverv2backend.repository;

import com.georgetudor.linksaverv2backend.models.Tag;
import org.springframework.data.repository.CrudRepository;

public interface TagRepository extends CrudRepository<Tag, Long> {
    Tag findById(long id);
    Tag findTagByDescription(String description);
}
