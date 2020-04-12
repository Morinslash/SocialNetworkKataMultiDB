package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;

public class InMemoryPostRepository implements PostRepository {
    @Override
    public void addPost(User anyUser, String message, long now) {
        throw new UnsupportedOperationException("Implement!");
    }
}
