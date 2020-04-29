package com.codenation.aceleradev.service.interfaces;

import java.util.Optional;

import com.codenation.aceleradev.entity.User;

public interface UserServiceInterface extends ServiceInterface<User> {

    Optional<User> findById(Long userId);

}