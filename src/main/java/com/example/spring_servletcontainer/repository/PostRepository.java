package com.example.spring_servletcontainer.repository;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class PostRepository {
    private final int BLOCKING_QUEUE_CAPACITY = 255;
    private final int INDEX_INITIAL_VALUE = 0;
    BlockingQueue<Post> posts = new ArrayBlockingQueue<>(BLOCKING_QUEUE_CAPACITY);
    private final AtomicInteger index = new AtomicInteger(INDEX_INITIAL_VALUE);

    private int autoincrement() {
        return index.incrementAndGet();
    }

    public BlockingQueue<Post> all() {
        return posts;
    }

    public Optional<Post> getById(long id) {
        return posts.stream().filter(x -> x.getId() == id).findFirst();
    }

    public Post save(Post post) {
        //Ниже обработка когда id = 0

        if (post.getId() == 0) {
            post.setId(autoincrement());
            posts.add(post);
        } else {
            //Ниже обработка когда id != 0
            Optional<Post> postOptional = getById(post.getId());
            if (postOptional.isPresent()) {
                Post updatedPost = postOptional.get();
                posts.remove(updatedPost);
                updatedPost.setMessage(post.getMessage());
                posts.add(updatedPost);
            }
        }
        return post;
    }

    public void removeById(long id) {
        posts.removeIf(x -> x.getId() == id);
    }
}
