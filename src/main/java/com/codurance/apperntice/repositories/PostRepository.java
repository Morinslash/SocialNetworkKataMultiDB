package com.codurance.apperntice.repositories;

import com.codurance.apperntice.entities.User;

public interface PostRepository {
    void addPost(User anyUser, String message, long now);
}
