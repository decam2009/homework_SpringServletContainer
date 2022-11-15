package com.example.spring_servletcontainer.service;

import com.example.spring_servletcontainer.repository.Post;
import com.example.spring_servletcontainer.repository.PostRepository;

import java.util.List;
import java.util.Optional;

public class PostService {
    PostRepository repository;

    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> all() {
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
