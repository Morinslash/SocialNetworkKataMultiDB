package com.codurance.apperntice;

import com.codurance.apperntice.clients.SocialNetworkClient;
import com.codurance.apperntice.commands.CommandFactory;
import com.codurance.apperntice.repositories.in_memory.InMemoryFollowRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryPostRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryUserRepository;
import com.codurance.apperntice.service.PrintService;
import com.codurance.apperntice.service.SocialService;
import com.codurance.apperntice.service.UserService;
import com.codurance.apperntice.utils.Parser;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AcceptanceTests {

    public static final long CURRENT_TIME = 1586609940L;

    @Mock
    private Console console;
    @Mock
    private Clock clock;

    private SocialNetworkClient socialNetworkClient;

    @BeforeEach
    void setUp() {
        Parser parser = new Parser();
        PostFormatter formatter = new PostFormatter();

        InMemoryPostRepository postRepository = new InMemoryPostRepository();
        InMemoryUserRepository userRepository = new InMemoryUserRepository();
        InMemoryFollowRepository followRepository = new InMemoryFollowRepository();

        PrintService printService = new PrintService(formatter, console);
        UserService userService = new UserService(clock, printService, postRepository, followRepository);
        SocialService socialService = new SocialService(userRepository);

        CommandFactory commandFactory = new CommandFactory(parser, userService);

        socialNetworkClient = new SocialNetworkClient(commandFactory, socialService);
    }

    @Test
    public void when_user_post_new_post_user_has_new_post() {
        long postTimestamp = CURRENT_TIME - 300000;

        when(clock.now())
                .thenReturn(postTimestamp)
                .thenReturn(CURRENT_TIME);

        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Alice");

        verify(console).print("I love the weather today (5 minutes ago)");
    }

    @Test
    void read_other_users_timelines_with_multiple_posts() {

        long aliceTimestamp = CURRENT_TIME - 300000;
        long bobFirstPostTimestamp = CURRENT_TIME - 120000;
        long bobSecondPostTimestamp = CURRENT_TIME - 60000;

        when(clock.now()).thenReturn(aliceTimestamp)
                .thenReturn(bobFirstPostTimestamp)
                .thenReturn(bobSecondPostTimestamp)
                .thenReturn(CURRENT_TIME);

        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Bob -> Damn! We lost!");
        socialNetworkClient.processUserInput("Bob -> Good game though.");
        socialNetworkClient.processUserInput("Alice");
        socialNetworkClient.processUserInput("Bob");

        verify(console).print("I love the weather today (5 minutes ago)");
        verify(console).print("Good game though. (1 minute ago)\n" +
                        "Damn! We lost! (2 minutes ago)");
    }

    @Test
    void user_can_follow_other_user_and_see_followed_user_posts_on_user_wall() {
        long aliceTimestamp = CURRENT_TIME - 300000;
        when(clock.now()).thenReturn(aliceTimestamp)
                .thenReturn(CURRENT_TIME - 2000)
                .thenReturn(CURRENT_TIME);

        socialNetworkClient.processUserInput("Alice -> I love the weather today");
        socialNetworkClient.processUserInput("Charlie -> I'm in New York today! Anyone want to have a coffee?");
        socialNetworkClient.processUserInput("Charlie follows Alice");
        socialNetworkClient.processUserInput("Charlie wall");

        verify(console).print("Charlie - I'm in New York today! Anyone want to have a coffee? (2 seconds ago)\n" +
                "Alice - I love the weather today (5 minutes ago)");
    }
}
