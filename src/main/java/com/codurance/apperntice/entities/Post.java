package com.codurance.apperntice.entities;

public class Post {
    public final User user;
    public final String message;
    public final long timestamp;

    public Post(User user, String message, long timestamp) {
        this.user = user;
        this.message = message;
        this.timestamp = timestamp;
    }

}
