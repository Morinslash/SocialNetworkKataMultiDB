package com.codurance.apperntice.command;

import com.codurance.apperntice.parser.Parser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommandFactoryShould {
    @Mock private Parser parser;

    @Test
    void return_post_command_when_user_input_contain_post() {
        String userInput = "Alice -> Hello!";
        String[] parsedInput = {"Alice", "->", "Hello!"};
        CommandFactory commandFactory = new CommandFactory(parser);

        when(parser.parseInput(userInput)).thenReturn(parsedInput);
        Command postCommand = commandFactory.getCommand(userInput);

        assertEquals(postCommand.getClass(), PostCommand.class);
    }
}