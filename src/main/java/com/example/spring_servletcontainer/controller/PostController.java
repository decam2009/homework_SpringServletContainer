package com.example.spring_servletcontainer.controller;

import com.example.spring_servletcontainer.repository.Post;
import com.example.spring_servletcontainer.service.PostService;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Reader;
import java.util.UUID;

public class PostController {
    public final static String APPLICATION_JSON = "application/json";
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    public synchronized void all(HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var data = postService.all();
        final var gson = new Gson();
        response.getWriter().print(gson.toJson(data));
    }

    public synchronized void getById(long id, HttpServletResponse response) {
        postService.getById(id);
    }

    public synchronized void save(Reader body, HttpServletResponse response) throws IOException {
        response.setContentType(APPLICATION_JSON);
        final var gson = new Gson();
        final var post = gson.fromJson(body, Post.class);
        final var data = postService.save(post);
        response.getWriter().print(gson.toJson(post));
    }

    public synchronized void removeById(long id, HttpServletResponse response) {
        postService.removeById(id);
    }
}
