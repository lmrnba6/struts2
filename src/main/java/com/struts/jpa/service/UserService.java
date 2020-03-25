package com.struts.jpa.service;

import com.struts.jpa.model.User;
import com.struts.jpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository<User> userRepository;

    @Transactional
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    public User findByUserNameAndPassword(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Transactional
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    @Transactional
    public void deleteUser(User u) {
        userRepository.delete(u);
    }

    @Transactional
    public User addUser(User person) {
        return userRepository.save(person);
    }

    @Transactional
    public boolean updateUser(User person) {
        return userRepository.save(person) != null;
    }
}
