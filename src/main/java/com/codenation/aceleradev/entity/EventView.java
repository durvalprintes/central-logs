package com.codenation.aceleradev.entity;

import java.time.LocalDateTime;

public interface EventView {

    Long getId();

    Level getLevel();

    String getDescription();

    String getSource();

    Long getQuantity();

    LocalDateTime getCreatedAt();

}