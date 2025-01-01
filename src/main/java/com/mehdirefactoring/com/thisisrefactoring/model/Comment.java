package com.mehdirefactoring.com.thisisrefactoring.model;


// Data Class code smell
public class Comment {
    private Long id;
    private Long blogPostId;
    private String author;
    private String content; // No validation for content

    public Comment(Long id, Long blogPostId, String author, String content) {
        this.id = id;
        this.blogPostId = blogPostId;
        this.author = author;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogPostId() {
        return blogPostId;
    }

    public void setBlogPostId(Long blogPostId) {
        this.blogPostId = blogPostId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
