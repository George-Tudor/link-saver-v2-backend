package com.georgetudor.linksaverv2backend.repository;

import com.georgetudor.linksaverv2backend.models.Link;
import org.springframework.data.repository.CrudRepository;



public interface LinkRepository extends CrudRepository<Link, Long> {
    <Link> void findById(Long id);
    <Link> Iterable<com.georgetudor.linksaverv2backend.models.Link> findAllByUserId(Long id);
    Link findById(long id);

}
