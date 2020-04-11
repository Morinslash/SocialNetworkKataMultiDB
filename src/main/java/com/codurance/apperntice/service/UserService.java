package com.codurance.apperntice.service;

import com.codurance.apperntice.command.Command;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.utils.Clock;

public class UserService {
    private UserRepository userRepository;
    private Clock clock;

    public UserService(UserRepository userRepository, Clock clock) {
        this.userRepository = userRepository;
        this.clock = clock;
    }

    public void execute(Command postCommand) {
        postCommand.execute(userRepository, clock.now());
    }
}
