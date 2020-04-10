package com.codurance.apperntice;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AcceptancePost {
    @Mock private Console console;

    @Test
    public void when_user_post_new_post_user_has_new_post() {
        SocialNetworkClient socialNetworkClient = new SocialNetworkClient();
        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Alice");

        verify(console).print("I love the weather today (5 minutes ago)");
    }
}
