package com.codurance.apperntice.command;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.UserRepository;
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
    public static final String USERNAME = "Alice";
    public static final String MESSAGE = "Hello!";
    public static final long TIMESTAMP = 1234567;


    @Test
    void if_new_user_create_user_and_store_post() {
        PostCommand postCommand = new PostCommand(USERNAME, MESSAGE);

        when(userRepository.getUser(USERNAME)).thenReturn(anyUser);

        postCommand.execute(userRepository, TIMESTAMP);

        verify(userRepository).getUser(USERNAME);
        verify(anyUser).addNewPost(MESSAGE, TIMESTAMP);
    }
}