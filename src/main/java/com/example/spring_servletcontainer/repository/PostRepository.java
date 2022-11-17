package com.example.spring_servletcontainer.repository;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

public interface PostRepository {
    BlockingQueue<Post> all();

    Optional<Post> getById(long id);

    Post save(Post post);

    void removeById(long id);
}
