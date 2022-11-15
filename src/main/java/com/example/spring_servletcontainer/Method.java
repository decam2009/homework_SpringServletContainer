package com.example.spring_servletcontainer;

public enum Method {
    GET("GET"),
    POST("POST"),
    DELETE("DELETE");

    private String name;

    Method(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
