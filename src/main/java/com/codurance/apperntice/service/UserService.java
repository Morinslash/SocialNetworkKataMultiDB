package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;

import java.util.List;

public class UserService {
    private Clock clock;
    private PostRepository postRepository;
    private PrintService printService;

    public UserService(Clock clock, PostRepository postRepository, PrintService printService) {
        this.clock = clock;
        this.postRepository = postRepository;
        this.printService = printService;
    }

    public void addNewPost(User user, String message) {
        postRepository.storePost(user, message, clock.now());
    }

    public void printPosts(User user) {
        List<Post> userPosts = postRepository.getUserPosts(user);
        printService.printPosts(userPosts, clock.now());
    }
}
