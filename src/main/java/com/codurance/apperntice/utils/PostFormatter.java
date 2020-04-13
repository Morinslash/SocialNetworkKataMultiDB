package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PostFormatter {

    public String formatUserPosts(List<Post> posts, long currentTime) {
        StringBuilder formattedOutput = new StringBuilder();
        ArrayList<Post> mutablePosts = reversePosts(posts);
        mutablePosts.forEach(post -> {
            formattedOutput.append(formatUserPost(currentTime, post));
        });
        return formattedOutput.toString();
    }
    private ArrayList<Post> reversePosts(List<Post> posts) {
        ArrayList<Post> mutablePosts = new ArrayList<>(posts);
        Collections.reverse(mutablePosts);
        return mutablePosts;
    }

    private String formatUserPost(long currentTime, Post post) {
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
