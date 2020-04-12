package com.codurance.apperntice;

import com.codurance.apperntice.command.CommandFactory;
import com.codurance.apperntice.parser.Parser;
import com.codurance.apperntice.repositories.in_memory.InMemoryPostRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryUserRepository;
import com.codurance.apperntice.service.SocialService;
import com.codurance.apperntice.service.UserService;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AcceptancePost {

    @Mock private Console console;
    @Mock private Clock clock;

    @Test
    public void when_user_post_new_post_user_has_new_post() {
        UserService userService = new UserService(clock, new InMemoryPostRepository());
        CommandFactory commandFactory = new CommandFactory(new Parser(), userService);
        SocialService socialService = new SocialService(new InMemoryUserRepository());
        SocialNetworkClient socialNetworkClient = new SocialNetworkClient(commandFactory, socialService);
        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Alice");

        verify(console).print("I love the weather today (5 minutes ago)");
    }
}
