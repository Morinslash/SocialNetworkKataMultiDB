package com.codurance.apperntice.repositories;

import com.codurance.apperntice.entities.User;

public interface FollowRepository {
    void newFollow(User anyUser, User userToFollow);
}
