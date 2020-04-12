package com.codurance.apperntice.command;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;

public class ReadCommand implements Command {
    private User user;
    private UserService userService;

    public ReadCommand(User user, UserService userService) {
        this.user = user;
        this.userService = userService;
    }

    @Override
    public void execute(UserRepository userRepository) {
        User user = userRepository.getUser(this.user);
        userService.printPosts(user);
    }
}
