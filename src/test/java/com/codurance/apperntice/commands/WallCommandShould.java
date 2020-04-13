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
class WallCommandShould {
    @Mock private User anyUser;
    @Mock private UserService userService;
    @Mock private UserRepository userRepository;

    @Test
    void name() {
        WallCommand wallCommand = new WallCommand(anyUser, userService);

        when(userRepository.getUser(anyUser)).thenReturn(anyUser);

        wallCommand.execute(userRepository);

        verify(userService).printWall(anyUser);
    }
}