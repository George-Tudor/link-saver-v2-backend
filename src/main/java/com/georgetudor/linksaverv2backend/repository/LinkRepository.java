package com.georgetudor.linksaverv2backend.repository;

import com.georgetudor.linksaverv2backend.models.Link;
import org.springframework.data.repository.CrudRepository;



public interface LinkRepository extends CrudRepository<Link, Integer> {
    <Link> void findById(Integer id);
}
