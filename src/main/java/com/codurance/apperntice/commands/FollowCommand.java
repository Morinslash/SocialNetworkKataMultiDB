package com.codurance.apperntice.commands;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;

public class FollowCommand implements Command{
    private final User user;
    private final String userToFollow;
    private final UserService userService;

    public FollowCommand(User user, String usernameToFollow, UserService userService) {
        this.user = user;
        this.userToFollow = usernameToFollow;
        this.userService = userService;
    }

    @Override
    public void execute(UserRepository userRepository) {
        User user = userRepository.getUser(this.user);
        User userToFollow = userRepository.getUserByName(this.userToFollow);
        userService.follow(user, userToFollow);
    }
}
