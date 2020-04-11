package com.codurance.apperntice.utils;

import java.util.Date;

public class Clock {

    private final Date date;

    public Clock() {
        date = new Date();
    }

    public long now() {
        return date.getTime();
    }
}
