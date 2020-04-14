package com.codurance.apperntice.commands;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.utils.Parser;
import com.codurance.apperntice.service.UserService;

public class CommandFactory {
    public static final String POST_COMMAND = "->";
    public static final String FOLLOW_COMMAND = "follows";
    public static final String WALL_COMMAND = "wall";
    private Parser parser;
    private UserService userService;

    public CommandFactory(Parser parser, UserService userService) {
        this.parser = parser;
        this.userService = userService;
    }

    public Command getCommand(String userInput) {
        String[] parsedInput = parser.parseInput(userInput);
        User user = new User(parsedInput[0]);
//TODO think about other solution for parsedInput
        if (parsedInput[1] == null) {
            return new ReadCommand(user, userService);
        }
        if (parsedInput[1].equals(POST_COMMAND)) {
            return new PostCommand(user, parsedInput[2], userService);
        }
        if (parsedInput[1].equals(FOLLOW_COMMAND)) {
            return new FollowCommand(user, parsedInput[2], userService);
        }
        if (parsedInput[1].equals(WALL_COMMAND)) {
            return new WallCommand(user, userService);
        }

        throw new UnsupportedOperationException("Unknown command");
    }
}
