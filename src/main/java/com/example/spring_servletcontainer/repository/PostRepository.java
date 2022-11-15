package com.example.spring_servletcontainer.repository;

import java.util.*;

public class PostRepository {

    List<Post> posts = new ArrayList<>();
    private static int index = 0;

    private int autoincrement() {
        return index++;
    }

    public List<Post> all() {
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
