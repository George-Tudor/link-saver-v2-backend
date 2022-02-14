package com.georgetudor.linksaverv2backend.repository;
import com.georgetudor.linksaverv2backend.models.UserDao;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDao, Integer> {
    UserDao findByUsername(String username);
}
