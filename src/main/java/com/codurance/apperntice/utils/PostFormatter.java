package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;

import java.util.List;

public class PostFormatter {

    public String formatUserPosts(List<Post> posts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        posts.forEach(post -> {
            formattedOutput.append(formatReadUserPost(currentTime, post));
        });
        return formattedOutput.toString().trim();
    }

    public String formatWallPosts(List<Post> usersPosts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        usersPosts.forEach(post -> {
            formattedOutput.append(formatUserWallPosts(currentTime, post));
        });
        return formattedOutput.toString().trim();
    }

    private String formatUserWallPosts(long currentTime, Post post) {
        return String.format("%s - %s (%s)\n",
                post.user.username,
                post.message,
                formatTime(post.timestamp, currentTime));
    }

    private String formatReadUserPost(long currentTime, Post post) {
        return String.format("%s (%s)\n",
                post.message,
                formatTime(post.timestamp, currentTime));
    }

    private String formatTime(long timestamp, long currentTime) {
        long timeAgo = currentTime - timestamp;
        return getTimeUnit(timeAgo);
    }

    private String getTimeUnit(long timeAgo) {
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
