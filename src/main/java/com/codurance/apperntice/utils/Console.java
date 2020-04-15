package com.codurance.apperntice.utils;

import java.util.Scanner;

//TODO finish console class to build app!
public class Console {

    private Scanner scanner = new Scanner(System.in);

    public void print(String output) {
        System.out.println(output);
    }

    public String getUserInput() {
        System.out.print('>');
        return scanner.nextLine();
    }
}
