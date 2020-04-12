package com.codurance.apperntice.command;

import com.codurance.apperntice.parser.Parser;
import com.codurance.apperntice.service.UserService;

public class CommandFactory {
    private Parser parser;
    private UserService userService;

    public CommandFactory(Parser parser, UserService userService) {
        this.parser = parser;
        this.userService = userService;
    }

    public Command getCommand(String userInput) {
        String[] parsedInput = parser.parseInput(userInput);
        if(parsedInput[1].equals("->")){
            return new PostCommand(parsedInput[0],parsedInput[2], userService);
        }
        throw new UnsupportedOperationException("Implement me!");
    }
}
