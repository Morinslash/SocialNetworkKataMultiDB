package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryUserRepositoryShould {

    public static final String USERNAME = "Alice";

    @Test
    void add_user_to_repository_if_not_exists() {
        InMemoryUserRepository repository = new InMemoryUserRepository();
        User user = repository.getUser(new User(USERNAME));

        assertEquals(USERNAME, user.username);
    }
}