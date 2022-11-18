package com.example.spring_servletcontainer.repository;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

public interface PostRepository {
    public BlockingQueue<Post> all();

    public Optional<Post> getById(long id);

    public Post save(Post post);

    public void removeById(long id);
}
