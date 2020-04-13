package com.codurance.apperntice.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static final String REGEX = "(\\w+)(\\s(->|follows|wall)(\\s(.*))*)*";
    private Pattern pattern;

    public Parser() {
        pattern = Pattern.compile(REGEX);
    }

    public String[] parseInput(String input){
        Matcher matcher = pattern.matcher(input);
        matcher.matches();
        return new String[] {matcher.group(1), matcher.group(3), matcher.group(5)};
    }
}
