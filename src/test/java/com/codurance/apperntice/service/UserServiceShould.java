package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.utils.Clock;
import org.junit.jupiter.api.BeforeEach;
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
    @Mock private User userToFollow;
    @Mock private Post post;
    @Mock private Clock clock;
    @Mock private PostRepository postRepository;
    @Mock private PrintService printService;
    @Mock private FollowRepository followRepository;

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService(clock, postRepository, printService, followRepository);
    }

    @Test
    void store_post_for_user_in_repository() {
        when(clock.now()).thenReturn(TIMESTAMP);

        userService.addNewPost(anyUser, MESSAGE);

        verify(postRepository).storePost(anyUser, MESSAGE, clock.now());
    }

    @Test
    void print_user_posts_to_console() {
        List<Post> posts = List.of(this.post);

        when(clock.now()).thenReturn(TIMESTAMP);
        when(postRepository.getUserPosts(anyUser)).thenReturn(posts);
        userService.printPosts(anyUser);

        verify(printService).printPosts(posts, clock.now());
    }

    @Test
    void add_new_user_to_follow_list_of_user() {
        userService.followUser(anyUser, userToFollow);
        verify(followRepository).newFollow(anyUser, userToFollow);
    }
}