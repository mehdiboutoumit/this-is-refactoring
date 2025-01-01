package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import com.mehdirefactoring.com.thisisrefactoring.repository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment addComment(Comment comment) {
        // No validation for comment content
        return commentRepository.save(comment);
    }
}
