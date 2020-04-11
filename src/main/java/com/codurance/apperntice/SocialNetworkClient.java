package com.codurance.apperntice;

public class SocialNetworkClient {
    private CommandFactory commandFactory;

    public SocialNetworkClient(CommandFactory commandFactory) {
        this.commandFactory = commandFactory;
    }

    public void processUserInput(String userInput) {
        Command command = commandFactory.getCommand(userInput);
        command.execute();
    }
}
