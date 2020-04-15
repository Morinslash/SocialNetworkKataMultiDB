package com.codurance.apperntice.utils;

import java.util.Date;

public class Clock {

    public long now() {
        return new Date().getTime();
    }
}
