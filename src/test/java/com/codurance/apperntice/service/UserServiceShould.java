package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceShould {
    public static final String MESSAGE = "Hello!";
    public static final long TIMESTAMP = 1234567L;

    @Mock private User anyUser;
    @Mock private Clock clock;
    @Mock private PostRepository postRepository;

    @Test
    void store_post_for_user_in_repository() {
        UserService userService = new UserService(clock, postRepository);

        when(clock.now()).thenReturn(TIMESTAMP);

        userService.addNewPost(anyUser, MESSAGE);

        verify(postRepository).storePost(anyUser, MESSAGE, clock.now());
    }
}