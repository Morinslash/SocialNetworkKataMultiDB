package com.codurance.apperntice.repositories;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;

import java.util.List;

public interface PostRepository {
    void storePost(User anyUser, String message, long now);

    List<Post> getUserPosts(User anyUser);
}
