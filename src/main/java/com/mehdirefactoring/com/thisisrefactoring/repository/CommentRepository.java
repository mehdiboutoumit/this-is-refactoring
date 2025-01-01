package com.mehdirefactoring.com.thisisrefactoring.repository;

import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository {
    private final List<Comment> comments = new ArrayList<>();

    public Comment save(Comment comment) {
        comments.add(comment);
        return comment;
    }

    public List<Comment> findByBlogPostId(Long blogPostId) {
        return comments.stream()
                .filter(comment -> comment.getBlogPostId().equals(blogPostId))
                .toList();
    }
}
