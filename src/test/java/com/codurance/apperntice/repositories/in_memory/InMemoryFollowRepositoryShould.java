package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryFollowRepositoryShould {

    public static final String USERNAME = "Charlie";
    public static final String USERNAME_TO_FOLLOW = "Alice";
    public static final String SECOND_USERNAME_TO_FOLLOW = "Bob";
    private InMemoryFollowRepository inMemoryFollowRepository;

    @BeforeEach
    void setUp() {
        inMemoryFollowRepository = new InMemoryFollowRepository();
    }

    @Test
    void add_new_user_to_follow_list() {
        User anyUser = new User(USERNAME);
        User userToFollow = new User(USERNAME_TO_FOLLOW);
        inMemoryFollowRepository.newFollow(anyUser, userToFollow);

        List<User> followed = inMemoryFollowRepository.getFollowed(anyUser);
        assertTrue(followed.contains(userToFollow));
    }

    @Test
    void add_second_user_follow_list() {
        User anyUser = new User(USERNAME);
        User userToFollow = new User(USERNAME_TO_FOLLOW);
        User secondUserToFollow = new User(SECOND_USERNAME_TO_FOLLOW);
        inMemoryFollowRepository.newFollow(anyUser, userToFollow);
        inMemoryFollowRepository.newFollow(anyUser, secondUserToFollow);

        List<User> followed = inMemoryFollowRepository.getFollowed(anyUser);
        assertTrue(followed.contains(userToFollow));
        assertTrue(followed.contains(secondUserToFollow));
    }
}