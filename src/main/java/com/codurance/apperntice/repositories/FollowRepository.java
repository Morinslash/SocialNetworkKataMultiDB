package com.codurance.apperntice.repositories;

import com.codurance.apperntice.entities.User;

import java.util.List;

public interface FollowRepository {
    void newFollow(User anyUser, User userToFollow);

    List<User> getFollowed(User anyUser);
}
