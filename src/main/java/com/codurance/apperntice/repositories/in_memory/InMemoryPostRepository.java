package com.codurance.apperntice.repositories.in_memory;

import com.codurance.apperntice.entities.Post;
import com.codurance.apperntice.entities.User;
import com.codurance.apperntice.repositories.PostRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryPostRepository implements PostRepository {
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
        List<Post> userPosts = new ArrayList<>();
//            TODO look into using better lambda
        posts.forEach(post ->  {
            if (post.user.equals(user)){
                userPosts.add(post);
            }
        });
        userPosts.sort((post1, post2) -> Long.compare(post2.timestamp, post1.timestamp));
        return Collections.unmodifiableList(userPosts);
    }

    @Override
    public List<Post> getUsersPostsFromNewest(List<User> users) {
        List<Post> usersPosts = new ArrayList<Post>();
//        TODO same, check better lambda usage here
        users.forEach(user ->{
            usersPosts.addAll(getUserPostsFromNewest(user));
        });
        usersPosts.sort((post1, post2) -> Long.compare(post2.timestamp, post1.timestamp));
        return Collections.unmodifiableList(usersPosts);
    }
}
