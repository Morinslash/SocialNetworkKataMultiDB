package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;

import java.util.List;

//TODO this class is doing too much, think about extracting
public class UserService {
    private Clock clock;
    private PostRepository postRepository;
    private PrintService printService;
    private FollowRepository followRepository;

    public UserService(Clock clock, PrintService printService, PostRepository postRepository, FollowRepository followRepository) {
        this.clock = clock;
        this.postRepository = postRepository;
        this.printService = printService;
        this.followRepository = followRepository;
    }

    public void addNewPost(User user, String message) {
        postRepository.storePost(user, message, clock.now());
    }

    public void printPosts(User user) {
        List<Post> userPosts = postRepository.getUserPostsFromNewest(user);
        printService.printPosts(userPosts, clock.now());
    }

    public void followUser(User anyUser, User userToFollow) {
        followRepository.newFollow(anyUser, userToFollow);
    }

    public void printWall(User user) {
        List<User> usersList = followRepository.getFollowed(user);
        List<Post> usersPosts = postRepository.getUsersPostsFromNewest(usersList);
        printService.printWall(usersPosts, clock.now());
    }
}
