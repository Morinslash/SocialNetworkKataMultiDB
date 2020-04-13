package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;

import java.util.List;

public class UserService {
    private Clock clock;
    private PostRepository postRepository;
    private PrintService printService;
    private FollowRepository followRepository;

    public UserService(Clock clock, PostRepository postRepository, PrintService printService, FollowRepository followRepository) {
        this.clock = clock;
        this.postRepository = postRepository;
        this.printService = printService;
        this.followRepository = followRepository;
    }

    public void addNewPost(User user, String message) {
        postRepository.storePost(user, message, clock.now());
    }

    public void printPosts(User user) {
        List<Post> userPosts = postRepository.getUserPosts(user);
        printService.printPosts(userPosts, clock.now());
    }

    public void followUser(User anyUser, User userToFollow) {
        followRepository.newFollow(anyUser, userToFollow);
    }
}
