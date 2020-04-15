package com.codurance.apperntice;

import com.codurance.apperntice.clients.SocialNetworkClient;
import com.codurance.apperntice.commands.CommandFactory;
import com.codurance.apperntice.repositories.in_memory.InMemoryFollowRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryPostRepository;
import com.codurance.apperntice.repositories.in_memory.InMemoryUserRepository;
import com.codurance.apperntice.service.PrintService;
import com.codurance.apperntice.service.SocialService;
import com.codurance.apperntice.service.UserService;
import com.codurance.apperntice.utils.Clock;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.Parser;
import com.codurance.apperntice.utils.PostFormatter;

public class App {
    public static void main(String[] args) {
        InMemoryUserRepository userRepository = new InMemoryUserRepository();
        InMemoryFollowRepository followRepository = new InMemoryFollowRepository();
        InMemoryPostRepository postRepository = new InMemoryPostRepository();

        Console console = new Console();
        Clock clock = new Clock();
        Parser parser = new Parser();
        PostFormatter formatter = new PostFormatter();

        PrintService printService = new PrintService(formatter, console);
        UserService userService = new UserService(clock, postRepository, printService, followRepository);
        SocialService socialService = new SocialService(userRepository);

        CommandFactory commandFactory = new CommandFactory(parser, userService);

        SocialNetworkClient socialNetworkClient = new SocialNetworkClient(commandFactory, socialService);

        while(true){
            socialNetworkClient.processUserInput(console.getUserInput());
        }
    }
}
