package com.codurance.apperntice;

import com.codurance.apperntice.clients.SocialNetworkClient;
import com.codurance.apperntice.commands.CommandFactory;
import com.codurance.apperntice.repositories.FollowRepository;
import com.codurance.apperntice.repositories.PostRepository;
import com.codurance.apperntice.repositories.UserRepository;
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

    private static final Console console = new Console();
    private static final Clock clock = new Clock();
    private static final Parser parser = new Parser();
    private static final PostFormatter formatter = new PostFormatter();

    public static void main(String[] args) {

        SocialNetworkClient socialNetworkClient = buildClient();
//        TODO print instructions before starting main loop
        while(true){
            socialNetworkClient.processUserInput(console.getUserInput());
        }
    }

    private static SocialNetworkClient buildClient(){
        UserRepository userRepository = new InMemoryUserRepository();
        FollowRepository followRepository = new InMemoryFollowRepository();
        PostRepository postRepository = new InMemoryPostRepository();

        PrintService printService = new PrintService(formatter, console);
        UserService userService = new UserService(clock, printService, postRepository, followRepository);
        SocialService socialService = new SocialService(userRepository);

        CommandFactory commandFactory = new CommandFactory(parser, userService);

        return new SocialNetworkClient(commandFactory, socialService);
    }

}
