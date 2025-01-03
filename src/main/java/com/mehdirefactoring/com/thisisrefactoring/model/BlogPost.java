package com.mehdirefactoring.com.thisisrefactoring.model;


import com.mehdirefactoring.com.thisisrefactoring.model.valueobject.Author;
import com.mehdirefactoring.com.thisisrefactoring.model.valueobject.Title;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class BlogPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Replace Primitive with Object Refactoring technique
    private Title title;
    private String content;
    private Author author;
    private String category;
    private int views;
    @OneToMany(mappedBy = "blogPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    public BlogPost() {
    }
    public BlogPost(Title title, String content, Author author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public Title getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Author getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getViews() {return views; }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setViews(int views) {
        this.views = views;
    }

    // Move Function Refactoring technique
    public void incrementViews() {
        this.views += 10;  // Responsibility moved here
    }

//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void addComment(Comment comment) {
//        comments.add(comment);
//    }

    public void displayPostDetails() {
        System.out.println("Title: " + title);
        System.out.println("Content: " + content);
        System.out.println("Author: " + author);
    }
}
