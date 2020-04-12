package com.codurance.apperntice.service;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.repositories.UserRepository;

public class SocialService {
    private UserRepository userRepository;

    public SocialService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void execute(Command postCommand) {
        postCommand.execute(userRepository);
    }
}
