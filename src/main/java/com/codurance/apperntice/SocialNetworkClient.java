package com.codurance.apperntice;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.command.CommandFactory;
import com.codurance.apperntice.service.SocialService;

public class SocialNetworkClient {
    private CommandFactory commandFactory;
    private SocialService socialService;

    public SocialNetworkClient(CommandFactory commandFactory, SocialService socialService) {
        this.commandFactory = commandFactory;
        this.socialService = socialService;
    }

    public void processUserInput(String userInput) {
        Command command = commandFactory.getCommand(userInput);
        socialService.execute(command);
    }
}
