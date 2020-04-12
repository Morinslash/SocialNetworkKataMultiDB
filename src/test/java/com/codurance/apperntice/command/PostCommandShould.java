package com.codurance.apperntice.command;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
import com.codurance.apperntice.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PostCommandShould {

    @Mock private UserRepository userRepository;
    @Mock private User anyUser;
    @Mock private UserService userService;
    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "Hello!";


    @Test
    void if_new_user_create_user_and_store_post() {
        PostCommand postCommand = new PostCommand(USERNAME, MESSAGE, userService);

        when(userRepository.getUser(USERNAME)).thenReturn(anyUser);

        postCommand.execute(userRepository);

        verify(userRepository).getUser(USERNAME);
        verify(userService).addNewPost(anyUser, MESSAGE);
    }
}