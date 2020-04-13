package com.codurance.apperntice.utils;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import org.junit.jupiter.api.BeforeEach;
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
    @Mock
    private User anyUser;
    private PostFormatter postFormatter;

    @BeforeEach
    void setUp() {
        postFormatter = new PostFormatter();
    }

    @Test
    void format_user_posts_list_with_one_post_1_second_ago() {
        long postTimestamp = 1234566L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (1 second ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_2_seconds_ago() {
        long postTimestamp = 1234565L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (2 seconds ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_1_minute_ago() {
        long postTimestamp = 1234507L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (1 minute ago)", formattedOutput);
    }

    @Test
    void format_user_posts_list_with_one_post_over_2_minutes_ago() {
        long postTimestamp = 1234443L;
        Post post = new Post(anyUser, POST_MESSAGE, postTimestamp);

        String formattedOutput = postFormatter.formatUserPosts(List.of(post), CURRENT_TIME);

        assertEquals("Hello! (2 minutes ago)", formattedOutput);
    }

    @Test
    void format_users_posts_lists_with_two_posts_in_desc_order() {
        long firstPostTimestamp = 1234565L;
        long secondPostTimestamp = 1234566L;
        List<Post> postsList = List.of(
                new Post(anyUser, POST_MESSAGE, firstPostTimestamp),
                new Post(anyUser, POST_MESSAGE, secondPostTimestamp));

        String formattedOutput = postFormatter.formatUserPosts(postsList, CURRENT_TIME);

        String expectedOutput = "Hello! (1 second ago)\n" +
                "Hello! (2 seconds ago)";

        assertEquals(expectedOutput, formattedOutput);
    }

    @Test
    void format_users_posts_for_wall_format() {
        long firstUserPostTimestamp = CURRENT_TIME - 1;
        long secondUserPostTimestamp = CURRENT_TIME - 4;

        List<Post> postsList = List.of(
                new Post(new User("Alice"), POST_MESSAGE, firstUserPostTimestamp),
                new Post(new User("Bob"), POST_MESSAGE, secondUserPostTimestamp)
        );

        String formattedOutput = postFormatter.formatWallPosts(postsList, CURRENT_TIME);

        String exceptedOutput = "Alice - Hello! (1 second ago)\n" +
                "Bob - Hello! (4 seconds ago)";

        assertEquals(exceptedOutput, formattedOutput);
    }
}