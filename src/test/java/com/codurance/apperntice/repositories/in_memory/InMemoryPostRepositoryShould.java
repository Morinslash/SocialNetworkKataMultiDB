package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryPostRepositoryShould {

    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "Hello!";
    public static final long TIMESTAMP = 1234567L;

    @Test
    void store_new_post_for_user() {
        InMemoryPostRepository repository = new InMemoryPostRepository();
        User anyUser = new User(USERNAME);
        repository.storePost(anyUser, MESSAGE, TIMESTAMP);

        assertEquals(1, repository.getUserPosts(anyUser).size());
    }
}