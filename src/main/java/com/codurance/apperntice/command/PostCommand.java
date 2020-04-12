package com.codurance.apperntice.command;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;

public class PostCommand implements Command{
    private final String username;
    private final String message;
    private UserService userService;

    public PostCommand(String username, String message, UserService userService) {
        this.username = username;
        this.message = message;
        this.userService = userService;
    }

    @Override
    public void execute(UserRepository userRepository) {
        User user = userRepository.getUser(username);
        userService.addNewPost(user, message);
    }
}
