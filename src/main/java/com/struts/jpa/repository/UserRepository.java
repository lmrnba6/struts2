package com.struts.jpa.repository;

import com.struts.jpa.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository<P> extends CrudRepository<User, Long> {
    User findByUserNameAndPassword(String userName, String password);
    User findByUserName(String userName);
}

