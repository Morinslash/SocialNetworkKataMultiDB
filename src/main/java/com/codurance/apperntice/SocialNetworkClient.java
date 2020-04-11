package com.codurance.apperntice;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.command.CommandFactory;
import com.codurance.apperntice.service.UserService;

public class SocialNetworkClient {
    private CommandFactory commandFactory;
    private UserService userService;

    public SocialNetworkClient(CommandFactory commandFactory, UserService userService) {
        this.commandFactory = commandFactory;
        this.userService = userService;
    }

    public void processUserInput(String userInput) {
        Command command = commandFactory.getCommand(userInput);
        userService.execute(command);
    }
}
