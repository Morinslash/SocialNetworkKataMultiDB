package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;

public class UserService {
    private Clock clock;
    private PostRepository postRepository;

    public UserService(Clock clock, PostRepository postRepository) {
        this.clock = clock;
        this.postRepository = postRepository;
    }

    public void addNewPost(User user, String message) {
        postRepository.storePost(user, message, clock.now());
    }
}
