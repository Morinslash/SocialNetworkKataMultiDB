package com.codurance.apperntice.commands;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FollowCommandShould {
    private final String FOLLOWED_USERNAME = "Alice";

    @Mock private User anyUser;
    @Mock private User userToFollow;
    @Mock private UserService userService;
    @Mock private UserRepository userRepository;

    @Test
    void add_new_followed_user_to_user_follow_repository() {
        FollowCommand followCommand = new FollowCommand(anyUser, FOLLOWED_USERNAME, userService);

        when(userRepository.getUser(anyUser)).thenReturn(anyUser);
        when(userRepository.getUserByName(FOLLOWED_USERNAME)).thenReturn(userToFollow);

        followCommand.execute(userRepository);

        verify(userService).followUser(anyUser, userToFollow);
    }
}