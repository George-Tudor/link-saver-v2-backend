package com.georgetudor.linksaverv2backend.repository;

import com.georgetudor.linksaverv2backend.models.Link;
import org.springframework.data.repository.CrudRepository;



public interface LinkRepository extends CrudRepository<Link, Long> {
    <Link> Iterable<com.georgetudor.linksaverv2backend.models.Link> findAllByUserId(Long id);
    Link findByUrl(String url);
}
