package com.codurance.apperntice.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class ParserShould {
    @Test
    void return_array_of_username_post_command_and_message_from_user_input() {
        Parser parser = new Parser();
        String[] parsedInput = parser.parseInput("Alice -> Hello!");
        assertEquals("Alice", parsedInput[0]);
        assertEquals("->", parsedInput[1]);
        assertEquals("Hello!", parsedInput[2]);
    }

    @Test
    void return_array_with_username_and_null_null_for_read_input() {
        Parser parser = new Parser();
        String[] parsedInput = parser.parseInput("Alice");
        assertEquals("Alice", parsedInput[0]);
        assertNull(parsedInput[1]);
        assertNull(parsedInput[2]);
    }

    @Test
    void return_array_with_username_follow_command_and_username_to_follow() {
        Parser parser = new Parser();
        String[] parsedInput = parser.parseInput("Charlie follows Alice");
        assertEquals("Charlie", parsedInput[0]);
        assertEquals("follows", parsedInput[1]);
        assertEquals("Alice", parsedInput[2]);
    }
}