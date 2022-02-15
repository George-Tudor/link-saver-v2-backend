package com.georgetudor.linksaverv2backend.repository;
import com.georgetudor.linksaverv2backend.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
