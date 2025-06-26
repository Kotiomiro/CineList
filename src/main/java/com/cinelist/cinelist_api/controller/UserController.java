package com.cinelist.cinelist_api.controller;

import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.infra.security.annotation.RequireAdminPermission;
import com.cinelist.cinelist_api.repository.UserRepository;
import com.cinelist.cinelist_api.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Base64;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("users")
public class UserController {

    UserService service;
    UserRepository repository;

    UserController(UserService service, UserRepository repository) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public List<User> getAllUsers() {

        return service.getAllUsers();
    }

    @PostMapping("register_user")
    void saveUser(@RequestBody User user) {
        service.saveUser(user);
    }

    @RequireAdminPermission
    @DeleteMapping("/{id}")
    void deleteUser(@RequestBody User user) {
        service.deleteUser(user.getId());
    }

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
                user.getUsername().equals("user") && user.getPassword().equals("password");
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
                .substring("Basic".length()).trim();

        return () -> new String(Base64.getDecoder()
                .decode(authToken))
                .split(":")[0];
    }


}
