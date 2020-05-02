package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;

import com.codenation.aceleradev.validator.Level;

public interface EventWithoutLog {

    Long getId();

    Level getLevel();

    String getDescription();

    String getSource();

    Long getQuantity();

    LocalDateTime getCreatedAt();

}