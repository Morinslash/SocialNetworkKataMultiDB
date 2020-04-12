package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;

import java.util.List;

public class UserService {
    private Clock clock;
    private PostRepository postRepository;
    private PostFormatter formatter;
    private Console console;

    public UserService(Clock clock, PostRepository postRepository, PostFormatter formatter, Console console) {
        this.clock = clock;
        this.postRepository = postRepository;
        this.formatter = formatter;
        this.console = console;
    }

    public void addNewPost(User user, String message) {
        postRepository.storePost(user, message, clock.now());
    }

    public void printPosts(User user) {
        List<Post> userPosts = postRepository.getUserPosts(user);
        String formattedPosts = formatter.format(userPosts, clock.now());
        console.print(formattedPosts);
    }
}
