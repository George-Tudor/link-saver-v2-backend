package com.georgetudor.linksaverv2backend.repository;

import com.georgetudor.linksaverv2backend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
//    Collection<Link> findByUser(User user);
}
