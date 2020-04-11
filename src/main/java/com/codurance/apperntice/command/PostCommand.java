package com.codurance.apperntice.command;

import com.codurance.apperntice.repositories.UserRepository;

public class PostCommand implements Command{
    @Override
    public void execute(UserRepository userRepository) {
        throw new UnsupportedOperationException("Implement me!");
    }
}
