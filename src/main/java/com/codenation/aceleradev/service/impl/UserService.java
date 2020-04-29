package com.codenation.aceleradev.service.impl;

import java.util.Optional;

import com.codenation.aceleradev.entity.User;
import com.codenation.aceleradev.repository.UserRepository;
import com.codenation.aceleradev.service.interfaces.UserServiceInterface;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceInterface, UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    public Iterable<User> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findById(Long userId) {
        return repository.findById(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username).get();
    }

}