package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceShould {
    public static final String MESSAGE = "Hello!";
    public static final long TIMESTAMP = 1234567L;

    @Mock private User anyUser;
    @Mock private Clock clock;
    @Mock private PostRepository postRepository;
    @Mock private Post post;
    @Mock private PostFormatter formatter;
    @Mock private Console console;

    @Test
    void store_post_for_user_in_repository() {
        UserService userService = new UserService(clock, postRepository, formatter, console);

        when(clock.now()).thenReturn(TIMESTAMP);

        userService.addNewPost(anyUser, MESSAGE);

        verify(postRepository).storePost(anyUser, MESSAGE, clock.now());
    }

    @Test
    void print_user_posts_to_console() {
        UserService userService = new UserService(clock, postRepository, formatter, console);
        List<Post> posts = List.of(this.post);
        String formatterPosts = "Hello! (1s ago)";

        when(clock.now()).thenReturn(TIMESTAMP);
        when(postRepository.getUserPosts(anyUser)).thenReturn(posts);
        when(formatter.format(posts, clock.now())).thenReturn(formatterPosts);
        userService.printPosts(anyUser);

        verify(formatter).format(posts, clock.now());
        verify(console).print(formatterPosts);
    }
}