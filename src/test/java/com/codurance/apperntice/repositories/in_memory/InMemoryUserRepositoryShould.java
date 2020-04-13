package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void if_there_is_user_with_username_return_user() {
        UserRepository userRepository = new InMemoryUserRepository();
        User anyUser = new User(USERNAME);
        userRepository.getUser(anyUser);
        User foundedUser = userRepository.getUserByName(USERNAME);

        assertEquals(anyUser, foundedUser);
    }

    @Test
    void if_user_with_provided_username_not_exist_throw_NoSuchElementException() {
        UserRepository userRepository = new InMemoryUserRepository();
        assertThrows(NoSuchElementException.class, () ->{
            userRepository.getUserByName("NotValidName");
        });
    }
}