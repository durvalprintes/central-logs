package com.codenation.aceleradev.repository;

import java.util.Optional;

import com.codenation.aceleradev.entity.User;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Optional<User> findByEmail(String username);

}