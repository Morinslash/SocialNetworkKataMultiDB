package com.codurance.apperntice;

import com.codurance.apperntice.clients.SocialNetworkClient;
import com.codurance.apperntice.commands.CommandFactory;
import com.codurance.apperntice.utils.Parser;
import com.codurance.apperntice.repositories.in_memory.InMemoryPostRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryUserRepository;
import com.codurance.apperntice.service.PrintService;
import com.codurance.apperntice.service.SocialService;
import com.codurance.apperntice.service.UserService;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AcceptanceTests {

    @Mock
    private Console console;
    @Mock
    private Clock clock;

    @Test
    public void when_user_post_new_post_user_has_new_post() {
        PrintService printService = new PrintService(new PostFormatter(), console);
        UserService userService = new UserService(clock, new InMemoryPostRepository(), printService);
        CommandFactory commandFactory = new CommandFactory(new Parser(), userService);
        SocialService socialService = new SocialService(new InMemoryUserRepository());
        SocialNetworkClient socialNetworkClient = new SocialNetworkClient(commandFactory, socialService);

        when(clock.now())
                .thenReturn(1586609640L)
                .thenReturn(1586609940L);

        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Alice");

        verify(console).print("I love the weather today (5 minutes ago)");
    }
}
