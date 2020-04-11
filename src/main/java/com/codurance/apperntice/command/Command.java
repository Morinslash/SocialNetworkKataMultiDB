package com.codurance.apperntice.command;

import com.codurance.apperntice.repositories.UserRepository;

public interface Command {
    void execute(UserRepository userRepository, long timestamp);
}
