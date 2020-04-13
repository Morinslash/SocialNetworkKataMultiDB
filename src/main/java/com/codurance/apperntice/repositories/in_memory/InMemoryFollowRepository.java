package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;

public class InMemoryFollowRepository implements FollowRepository {
    @Override
    public void newFollow(User anyUser, User userToFollow) {
        throw new UnsupportedOperationException("Implement me");
    }
}
