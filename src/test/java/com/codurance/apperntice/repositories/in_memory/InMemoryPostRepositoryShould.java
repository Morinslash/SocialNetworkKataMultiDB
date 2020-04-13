package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InMemoryPostRepositoryShould {

    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "Hello!";
    public static final long TIMESTAMP = 1234567L;
    private InMemoryPostRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryPostRepository();
    }

    @Test
    void store_new_post_for_user() {
        User anyUser = new User(USERNAME);
        repository.storePost(anyUser, MESSAGE, TIMESTAMP);

        assertEquals(1, repository.getUserPostsFromNewest(anyUser).size());
    }

    @Test
    void return_list_of_posts_for_all_users_from_newest() {
        User anyUser = new User(USERNAME);
        User followedUser = new User("Bob");
        long secondTimestamp = TIMESTAMP + 2;

        repository.storePost(anyUser, MESSAGE, TIMESTAMP);
        repository.storePost(followedUser, MESSAGE, secondTimestamp);

        List<Post> usersPosts = repository.getUsersPostsFromNewest(List.of(anyUser, followedUser));

        assertEquals(secondTimestamp, usersPosts.get(0).timestamp);
        assertEquals(TIMESTAMP, usersPosts.get(1).timestamp);
    }
}