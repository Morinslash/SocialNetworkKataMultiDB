package com.codurance.apperntice.command;

import com.codurance.apperntice.parser.Parser;

public class CommandFactory {
    private Parser parser;

    public CommandFactory(Parser parser) {
        this.parser = parser;
    }

    public Command getCommand(String userInput) {
        String[] parsedInput = parser.parseInput(userInput);
        if(parsedInput[1].equals("->")){
            return new PostCommand(parsedInput[0],parsedInput[2]);
        }
        throw new UnsupportedOperationException("Implement me!");
    }
}
