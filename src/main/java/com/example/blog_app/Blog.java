package com.example.blog_app;

public class Blog {

    private final Long id;
    private final String title;
    private final String content;

    public Blog(String title, String content, Long id) {
        this.title = title;
        this.content = content;
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getContent() {
        return this.content;
    }

    public Long getId() {
        return id;
    }
}
