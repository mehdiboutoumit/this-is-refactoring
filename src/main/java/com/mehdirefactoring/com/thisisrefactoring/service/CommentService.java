package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import com.mehdirefactoring.com.thisisrefactoring.repository.BlogPostRepository;
import com.mehdirefactoring.com.thisisrefactoring.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// Middle Man Code Smell
@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private BlogPostRepository blogPostRepository;


    public Comment addComment(Comment comment) {
        return commentRepository.save(comment); // Delegating to CommentRepository
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null); // Delegating to CommentRepository
    }

    public List<Comment> getAllCommentsForPost(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId); // Delegating to CommentRepository
    }

    // Move Function refactoring technique and Encapsulation
    public void addCommentToBlogPost(Long blogPostId, String author, String content) {
        BlogPost blogPost = blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));
        blogPost.addComment(author, content);
        blogPostRepository.save(blogPost);
    }
    public void deleteAllComments(Long blogPostId) {
        BlogPost blogPost = blogPostRepository.findById(blogPostId)
                .orElseThrow(() -> new RuntimeException("Blog post not found"));
        blogPost.removeAllComments();
        blogPostRepository.save(blogPost);
    }
}

