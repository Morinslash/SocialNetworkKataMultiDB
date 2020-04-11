package com.codurance.apperntice.command;

import com.codurance.apperntice.repositories.UserRepository;

public class PostCommand implements Command{
    private final String username;
    private final String message;

    public PostCommand(String username, String message) {
        this.username = username;
        this.message = message;
    }

    @Override
    public void execute(UserRepository userRepository, long timestamp) {
        throw new UnsupportedOperationException("Implement me!");
    }
}
