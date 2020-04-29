package com.codenation.aceleradev.controller;

import com.codenation.aceleradev.entity.User;
import com.codenation.aceleradev.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public Iterable<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return service.findById(id).get();
    }

    @PostMapping
    public User save(@RequestBody User user) {
        return service.save(user);
    }

}