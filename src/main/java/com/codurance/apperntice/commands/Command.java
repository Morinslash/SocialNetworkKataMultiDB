package com.codurance.apperntice.commands;

import com.codurance.apperntice.repositories.UserRepository;

public interface Command {
    void execute(UserRepository userRepository);
}
