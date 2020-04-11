package com.codurance.apperntice.parser;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserShould {
    @Test
    void return_array_of_username_command_message_from_user_input() {
        Parser parser = new Parser();
        String[] parsedInput = parser.parseInput("Alice -> Hello!");
        assertEquals("Alice", parsedInput[0]);
        assertEquals("->", parsedInput[1]);
        assertEquals("Hello!", parsedInput[2]);
    }
}