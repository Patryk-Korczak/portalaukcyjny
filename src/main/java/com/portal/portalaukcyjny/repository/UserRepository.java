package com.portal.portalaukcyjny.repository;

import com.portal.portalaukcyjny.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

    User findByLogin(String login);
}
