package com.example.spring_servletcontainer;

import com.example.spring_servletcontainer.controller.PostController;
import com.example.spring_servletcontainer.repository.PostRepositoryImpl;
import com.example.spring_servletcontainer.service.PostService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public PostController postController(PostService postService) {
        return new PostController(postService);
    }

    @Bean
    public PostService postService(PostRepositoryImpl postRepository) {
        return new PostService(postRepository);
    }

    @Bean
    public PostRepositoryImpl postRepository() {
        return new PostRepositoryImpl();
    }
}
