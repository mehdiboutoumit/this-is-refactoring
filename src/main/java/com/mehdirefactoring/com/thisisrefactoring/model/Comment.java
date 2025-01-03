package com.mehdirefactoring.com.thisisrefactoring.model;

import jakarta.persistence.*;

// Added behaviour to avoid Data Class
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private String content;
    @ManyToOne
    @JoinColumn(name = "blog_post_id", referencedColumnName = "id", nullable = false)
    private BlogPost blogPost;

    public Comment() {}

    // Constructor
    public Comment(BlogPost blogPost, String author, String content) {
        this.blogPost = blogPost;
        setAuthor(author);   // Uses setter to add validation
        setContent(content); // Uses setter to add validation
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPost getBlogPost() {
        return blogPost;
    }

    public void setBlogPost(BlogPost blogPost) {
        this.blogPost = blogPost;
    }

    public String getAuthor() {
        return author;
    }

    // Added validation in setter for author
    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty");
        }
        this.author = author;
    }

    // Added validation in setter for content
    public void setContent(String content) {
        if (content == null || content.length() < 10) { // Example validation
            throw new IllegalArgumentException("Content must be at least 10 characters long");
        }
        this.content = content;
    }

}
