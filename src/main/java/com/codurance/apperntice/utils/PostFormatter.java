package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;

import java.util.List;

public class PostFormatter {

    private final TimestampToHuman timestampToHuman;

    public PostFormatter() {
        timestampToHuman = new TimestampToHuman();
    }

    public String formatUserPosts(List<Post> posts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        posts.forEach(post -> {
            formattedOutput.append(formatUserReadPost(currentTime, post));
        });
        return formattedOutput.toString().trim();
    }

    public String formatWallPosts(List<Post> usersPosts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        usersPosts.forEach(post -> {
            formattedOutput.append(formatUserWallPost(currentTime, post));
        });
        return formattedOutput.toString().trim();
    }

    private String formatUserWallPost(long currentTime, Post post) {
        return String.format("%s - %s (%s)\n",
                post.user.username,
                post.message,
                timestampToHuman.format(post.timestamp, currentTime));
    }

    private String formatUserReadPost(long currentTime, Post post) {
        return String.format("%s (%s)\n",
                post.message,
                timestampToHuman.format(post.timestamp, currentTime));
    }
}

