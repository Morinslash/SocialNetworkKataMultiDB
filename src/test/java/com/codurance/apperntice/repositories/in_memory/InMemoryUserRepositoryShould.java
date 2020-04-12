package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryUserRepositoryShould {

    public static final String USERNAME = "Alice";

    @Test
    void add_user_to_repository_if_not_exists() {
        InMemoryUserRepository repository = new InMemoryUserRepository();
        User anyUser = new User(USERNAME);
        User repositoryUser = repository.getUser(anyUser);

        assertEquals(anyUser, repositoryUser);
    }

    @Test
    void if_user_already_exists_return_user_from_repository() {
        InMemoryUserRepository repository = new InMemoryUserRepository();
        User anyUser = new User(USERNAME);
        repository.getUser(anyUser);
        User repositoryUser = repository.getUser(anyUser);

        assertEquals(anyUser, repositoryUser);
    }
}