package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InMemoryPostRepository implements PostRepository {
    private final Comparator<Post> compareByTimestamp = (post1, post2) -> Long.compare(post2.timestamp, post1.timestamp);
    private List<Post> posts;

    public InMemoryPostRepository() {
        this.posts = new ArrayList<>();
    }

    @Override
    public void storePost(User user, String message, long timestamp) {
        Post newPost = new Post(user, message, timestamp);
        posts.add(newPost);
    }

    @Override
    public List<Post> getUserPostsFromNewest(User user) {
        Predicate<Post> byUser = post -> post.user.equals(user);
        return posts.stream()
                .filter(byUser)
                .sorted(compareByTimestamp)
                .collect(Collectors.toUnmodifiableList());
    }


    @Override
    public List<Post> getUsersPostsFromNewest(List<User> users) {
        List<Post> usersPosts = new ArrayList<Post>();
        users.forEach(user -> usersPosts.addAll(getUserPostsFromNewest(user)));
        usersPosts.sort(compareByTimestamp);
        return Collections.unmodifiableList(usersPosts);
    }
}
