package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
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


    public Comment addComment(Comment comment) {
        return commentRepository.save(comment); // Delegating to CommentRepository
    }

    public Comment getCommentById(Long commentId) {
        return commentRepository.findById(commentId).orElse(null); // Delegating to CommentRepository
    }

    public List<Comment> getAllCommentsForPost(Long blogPostId) {
        return commentRepository.findByBlogPostId(blogPostId); // Delegating to CommentRepository
    }

    // Insider Trading code smell
//    public void addCommentToBlogPost(BlogPost blogPost, String author, String content) {
//        // Accessing and modifying BlogPost's internal state directly
//        Comment newComment = new Comment(blogPost.getId(),author, content);
//        blogPost.getComments().add(newComment); // Insider Trading: Knows too much about BlogPost
//    }

//    public void deleteAllComments(BlogPost blogPost) {
//        blogPost.getComments().clear(); // Insider Trading: Modifies internal details of BlogPost
//    }
}

