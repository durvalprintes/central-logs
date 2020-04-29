package com.codenation.aceleradev.entity;

public enum Level {

    ERROR(0), WARNING(1), INFO(2);

    public int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}