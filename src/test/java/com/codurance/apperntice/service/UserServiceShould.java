package com.codurance.apperntice.service;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.utils.Clock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceShould {
    public static final long TIMESTAMP = 1234567l;
    @Mock private Command command;
    @Mock private UserRepository userRepository;
    @Mock private Clock clock;

    @Test
    void execute_post_command() {
        UserService userService = new UserService(userRepository, clock);

        when(clock.now()).thenReturn(TIMESTAMP);
        userService.execute(command);

        verify(command).execute(userRepository, clock.now());
    }
}