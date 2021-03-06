package com.codurance.apperntice.repositories;

import com.codurance.apperntice.entities.User;

public interface UserRepository {
    User getUser(User username);

    User getUserByName(String usernameToFollow);
}
