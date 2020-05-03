package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "The Event projection without Logs info")
public interface EventWithoutLog {

    Long getId();

    String getLevel();

    String getDescription();

    String getSource();

    Long getQuantity();

    LocalDateTime getCreatedAt();

}