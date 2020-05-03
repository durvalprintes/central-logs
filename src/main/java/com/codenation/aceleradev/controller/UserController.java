package com.codenation.aceleradev.controller;

import com.codenation.aceleradev.entity.User;
import com.codenation.aceleradev.service.impl.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping(path = "/api/user")
@Api(value = "Users Management", description = "Operations to user")
public class UserController {

    @Autowired
    private UserService service;

    @ApiOperation(value = "Get a specific User by ID", response = User.class)
    @GetMapping("/{id}")
    public User findById(
            @ApiParam(value = "User id from which User object will retrieve", required = true, example = "123") @PathVariable("id") Long id) {
        return service.findById(id).get();
    }

}