package com.codurance.apperntice.entities;

import java.util.Objects;

public class User {
    public final String username;

    public User(String username) {
        this.username = username;
    }

    public User(User user) {
        this.username = user.username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}
