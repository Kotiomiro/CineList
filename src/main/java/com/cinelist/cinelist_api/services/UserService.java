package com.cinelist.cinelist_api.services;


import com.cinelist.cinelist_api.domain.user.User;
import com.cinelist.cinelist_api.repository.UserRepository;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final ListableBeanFactory listableBeanFactory;
    UserRepository repository;

    UserService(UserRepository repository, ListableBeanFactory listableBeanFactory) {
        this.repository = repository;
        this.listableBeanFactory = listableBeanFactory;
    }

    public void saveUser(@RequestBody User user) {
        repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public void saveKotiomiro() {
        User user = new User();

        user.setLogin("kotiomiro4312");
        user.setUsername("kotiomiroooo");
        user.setEmail("AFADKJGDA@gmail.com");
        user.setPassword("ewr325sd2#");

        repository.save(user);
    }

    public Optional<String> findEmail(User user) {
        return user.getEmail().describeConstable();
    }

    public void deleteUser(UUID id) {
        repository.deleteById(id);
    }



}
