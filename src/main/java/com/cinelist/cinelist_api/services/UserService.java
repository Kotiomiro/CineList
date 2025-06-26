package com.cinelist.cinelist_api.services;


import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    UserRepository repository;

    UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void saveUser(User user) {
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
