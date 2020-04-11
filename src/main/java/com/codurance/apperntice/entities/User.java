package com.codurance.apperntice.entities;

public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public void addNewPost(String message, long timestamp) {
        throw new UnsupportedOperationException("implement me!");
    }
}
