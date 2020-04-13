package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryFollowRepositoryShould {

    public static final String USERNAME = "Charlie";
    public static final String USERNAME_TO_FOLLOW = "Alice";

    @Test
    void add_new_user_to_follow_list() {
        InMemoryFollowRepository inMemoryFollowRepository = new InMemoryFollowRepository();
        User anyUser = new User(USERNAME);
        User userToFollow = new User(USERNAME_TO_FOLLOW);
        inMemoryFollowRepository.newFollow(anyUser, userToFollow);

        List<User> followed = inMemoryFollowRepository.getFollowed(anyUser);
        assertTrue(followed.contains(userToFollow));
    }
}