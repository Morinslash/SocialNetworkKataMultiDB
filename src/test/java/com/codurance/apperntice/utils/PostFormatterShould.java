package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class PostFormatterShould {

    public static final long CURRENT_TIME = 1234567L;
    public static final String POST_MESSAGE = "Hello!";
    @Mock private User anyUser;

    @Test
    void format_user_posts_list_with_one_post_1_second_ago() {
        PostFormatter postFormatter = new PostFormatter();
        long postTimestamp = 1234566L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (1 second ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_2_seconds_ago() {
        PostFormatter postFormatter = new PostFormatter();
        long postTimestamp = 1234565L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (2 seconds ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_1_minute_ago() {
        PostFormatter postFormatter = new PostFormatter();
        long postTimestamp = 1234507L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (1 minute ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_over_2_minutes_ago() {
        PostFormatter postFormatter = new PostFormatter();
        long postTimestamp = 1234443L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (2 minutes ago)", formattedOutput);
    }


}