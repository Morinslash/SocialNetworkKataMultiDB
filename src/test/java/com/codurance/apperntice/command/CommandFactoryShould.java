package com.codurance.apperntice.command;

import com.codurance.apperntice.parser.Parser;
import com.codurance.apperntice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandFactoryShould {
    public static final String USERNAME = "Alice";
    @Mock private Parser parser;
    @Mock private UserService userService;

    @Test
    void return_post_command_when_user_input_contain_post() {
        String userInput = "Alice -> Hello!";
        String[] parsedInput = {"Alice", "->", "Hello!"};
        CommandFactory commandFactory = new CommandFactory(parser, userService);

        when(parser.parseInput(userInput)).thenReturn(parsedInput);
        Command postCommand = commandFactory.getCommand(userInput);

        assertEquals(postCommand.getClass(), PostCommand.class);
    }

    @Test
    void return_read_command_when_only_user_name_as_input() {
        String userInput = USERNAME;
        String[] parsedInput = {USERNAME, null, null};
        CommandFactory commandFactory = new CommandFactory(parser, userService);

        when(parser.parseInput(userInput)).thenReturn(parsedInput);

        Command command = commandFactory.getCommand(userInput);

        assertEquals(command.getClass(), ReadCommand.class);
    }
}