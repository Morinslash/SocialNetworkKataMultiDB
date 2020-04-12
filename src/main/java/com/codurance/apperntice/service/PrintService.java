package com.codurance.apperntice.service;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.utils.Console;
import com.codurance.apperntice.utils.PostFormatter;

import java.util.List;

public class PrintService {
    private final PostFormatter formatter;
    private final Console console;

    public PrintService(PostFormatter formatter, Console console) {
        this.formatter = formatter;
        this.console = console;
    }

    public void printPosts(List<Post> posts, long currentTime) {
        String formattedOutput = formatter.formatUserPosts(posts, currentTime);
        console.print(formattedOutput);
    }
}
