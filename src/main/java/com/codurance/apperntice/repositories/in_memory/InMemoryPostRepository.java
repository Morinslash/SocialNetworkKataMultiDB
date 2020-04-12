package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryPostRepository implements PostRepository {
    private List<Post> posts;

    public InMemoryPostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void storePost(User user, String message, long timestamp) {
        Post newPost = new Post(user, message, timestamp);
        posts.add(newPost);
    }

    @Override
    public List<Post> getUserPosts(User user) {
        List<Post> userPosts = new ArrayList<>();
        posts.forEach(post ->  {
            if (post.user.equals(user)){
                userPosts.add(post);
            }
        });
        return Collections.unmodifiableList(userPosts);
    }
}