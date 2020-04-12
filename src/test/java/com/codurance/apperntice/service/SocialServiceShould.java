package com.codurance.apperntice.service;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SocialServiceShould {
    @Mock private Command command;
    @Mock private UserRepository userRepository;

    @Test
    void execute_post_command() {
        SocialService socialService = new SocialService(userRepository);

        socialService.execute(command);

        verify(command).execute(userRepository);
    }
}