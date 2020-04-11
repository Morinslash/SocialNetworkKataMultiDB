package com.codurance.apperntice;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.command.CommandFactory;
import com.codurance.apperntice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SocialNetworkClientShould {


    @Mock private CommandFactory commandFactory;
    @Mock private Command postCommand;
    @Mock private UserService userService;

    @Test
    void execute_post_command_when_user_post() {
        String userInput = "Alice -> Hello!";

        SocialNetworkClient socialNetworkClient = new SocialNetworkClient(commandFactory, userService);

        when(commandFactory.getCommand(userInput)).thenReturn(postCommand);

        socialNetworkClient.processUserInput(userInput);

        verify(userService).execute(postCommand);
    }
}