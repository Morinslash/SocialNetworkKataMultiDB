package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.FollowRepository;

import java.util.*;

public class InMemoryFollowRepository implements FollowRepository {
    private Map<User, Set<User>> usersFollows;

    public InMemoryFollowRepository() {
        usersFollows = new HashMap<>();
    }

    @Override
    public void newFollow(User user, User userToFollow) {
        if (!usersFollows.containsKey(user)) {
            usersFollows.put(user, new HashSet<>());
        }
        usersFollows.get(user).add(userToFollow);
    }

//TODO Think about kicking in merging user to follow list here from user service
    @Override
    public List<User> getFollowed(User user) {
        ArrayList<User> usersFollowsList = new ArrayList<>(usersFollows.get(user));
        return usersFollowsList;
    }
}
