package com.example.spring_servletcontainer.repository;

import java.io.Serializable;
import java.util.UUID;

public class Post implements Serializable {
    long id;
    String message;

    public Post (String message) {
        this.id = 0;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
