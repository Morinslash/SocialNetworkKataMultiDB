package com.codurance.apperntice.commands;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;

public class PostCommand implements Command{
    private final User user;
    private final String message;
    private final UserService userService;

    public PostCommand(User user, String message, UserService userService) {
        this.user = user;
        this.message = message;
        this.userService = userService;
    }

    @Override
    public void execute(UserRepository userRepository) {
        User user = userRepository.getUser(this.user);
        userService.addNewPost(user, message);
    }
}
