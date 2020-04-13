package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PrintServiceShould {

    public static final long CURRENT_TIME = 1234567L;
    public static final long POST_TIMESTAMP = 1234566L;
    public static final String MESSAGE = "Hello!";
    public static final String FORMAT_MESSAGE = "Hello! (1 seconds ago)";

    @Mock
    private User anyUser;
    @Mock
    private PostFormatter formatter;
    @Mock
    private Console console;
    private PrintService printService;

    @BeforeEach
    void setUp() {
        printService = new PrintService(formatter, console);
    }

    @Test
    void format_and_print_posts_to_console() {
        Post post = new Post(anyUser, MESSAGE, POST_TIMESTAMP);
        List<Post> postsList = List.of(post);

        when(formatter.formatUserPosts(postsList, CURRENT_TIME)).thenReturn(FORMAT_MESSAGE);

        printService.printPosts(postsList, CURRENT_TIME);

        verify(console).print(FORMAT_MESSAGE);
    }

    @Test
    void format_user_wall_and_print_posts_to_console() {
        List<Post> usersPosts = List.of(
                new Post(anyUser, MESSAGE, POST_TIMESTAMP),
                new Post(anyUser, MESSAGE, POST_TIMESTAMP - 2)
        );
        String formattedMessage = "Alice - Hello! (\"1 second ago\")\n" +
                "Alice - Hello! (\"3 seconds ago\")\n";

        when(formatter.formatWallPosts(usersPosts, CURRENT_TIME)).thenReturn(formattedMessage);

        printService.printWall(usersPosts, CURRENT_TIME);

        verify(console).print(formattedMessage);

    }
}