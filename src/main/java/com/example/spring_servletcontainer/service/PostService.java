package com.example.spring_servletcontainer.service;

import com.example.spring_servletcontainer.repository.Post;
import com.example.spring_servletcontainer.repository.PostRepositoryImpl;

import java.util.Optional;
import java.util.concurrent.BlockingQueue;

public class PostService {
    PostRepositoryImpl repository;

    public PostService(PostRepositoryImpl repository) {
        this.repository = repository;
    }

    public BlockingQueue<Post> all() {
        return repository.all();
    }

    public Optional<Post> getById(long id) {
        return repository.getById(id);
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
