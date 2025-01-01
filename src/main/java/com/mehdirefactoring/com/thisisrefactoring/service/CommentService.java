package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import com.mehdirefactoring.com.thisisrefactoring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Middle Man Code Smell
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;


    public Comment addComment(Comment comment) {
        return commentRepository.save(comment); // Delegating to CommentRepository
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null); // Delegating to CommentRepository
    }

    public List<Comment> getAllCommentsForPost(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId); // Delegating to CommentRepository
    }
}

