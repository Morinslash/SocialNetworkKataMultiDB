package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;

import java.util.List;

public class PostFormatter {
    public String formatUserPosts(List<Post> posts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        posts.forEach(post -> {
            String timeAgo = calculate(post.timestamp, currentTime);
            String formattedPost = String.format("%s (%s)", post.message, timeAgo);
            formattedOutput.append(formattedPost);
        });
        return formattedOutput.toString();
    }

    private String calculate(long timestamp, long currentTime) {
        long timeAgo = currentTime - timestamp;
        if (timeAgo == 1) {
            return timeAgo + " second ago";
        }
        if (timeAgo < 60) {
            return timeAgo + " seconds ago";
        }
        if (timeAgo < 120) {
            return timeAgo / 60 + " minute ago";
        }
        return timeAgo / 60 + " minutes ago";

    }
}
