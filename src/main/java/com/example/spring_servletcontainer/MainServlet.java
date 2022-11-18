package com.example.spring_servletcontainer;

import com.example.spring_servletcontainer.controller.PostController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class MainServlet extends HttpServlet {

    private PostController controller;

    @Override
    public void init() {
        final var context = new AnnotationConfigApplicationContext(AppConfig.class);
        controller = context.getBean(PostController.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {
        try {
            final var path = req.getRequestURI();
            final var method = req.getMethod();
            if (method.equals(Method.GET.getName()) && path.equals("/api/posts")) {
                controller.all(resp);
            }
            if (method.equals(Method.GET.getName()) && path.matches("/api/posts/\\d+")) {
                controller.getById(1, resp);
            }
            if (method.equals(Method.POST.getName()) && path.equals("/api/posts")) {
                Reader body = req.getReader();
                controller.save(body, resp);
            }
            if (method.equals(Method.DELETE.getName()) && path.equals("/api/posts")) {
                controller.removeById(2, resp);
            }
            resp.setStatus(HttpServletResponse.SC_OK);
        } catch (Exception e) {
            e.printStackTrace();
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}