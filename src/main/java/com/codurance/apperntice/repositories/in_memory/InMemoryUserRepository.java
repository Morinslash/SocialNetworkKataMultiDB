package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;

public class InMemoryUserRepository implements UserRepository {
    @Override
    public User getUserByUsername(User username) {
        throw new UnsupportedOperationException("IMPLEMENT ME!");
    }
}
