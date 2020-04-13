package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

public class InMemoryUserRepository implements UserRepository {
    private Set<User> users;

    public InMemoryUserRepository() {
        this.users = new HashSet<>();
    }

    @Override
    public User getUser(User user) {
        Optional<User> repositoryUser = users.stream()
                .filter(u -> u.equals(user))
                .findFirst();

        if(repositoryUser.isPresent()){
            return repositoryUser.get();
        }

        users.add(user);
        return user;
    }

    @Override
    public User getUserByName(String username) {
        Optional<User> userToFollow = users.stream()
                .filter(u -> u.username.equals(username))
                .findFirst();
        if (userToFollow.isPresent()){
            return userToFollow.get();
        }
        throw new NoSuchElementException("User does not exist!");
    }
}
