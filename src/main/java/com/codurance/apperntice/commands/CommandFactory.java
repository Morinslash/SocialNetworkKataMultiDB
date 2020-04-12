package com.codurance.apperntice.commands;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.utils.Parser;
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
        User user = new User(parsedInput[0]);

        if(parsedInput[1] == null){
            return new ReadCommand(user, userService);
        }
        if(parsedInput[1].equals("->")){
            return new PostCommand(user,parsedInput[2], userService);
        }
        throw new UnsupportedOperationException("Implement me!");
    }
}
