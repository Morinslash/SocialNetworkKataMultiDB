package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;

import java.util.List;

public class InMemoryFollowRepository implements FollowRepository {
    @Override
    public void newFollow(User anyUser, User userToFollow) {
        throw new UnsupportedOperationException("Implement me");
    }

    @Override
    public List<User> getFollowed(User anyUser) {
        throw new UnsupportedOperationException("Implement!");
    }
}
