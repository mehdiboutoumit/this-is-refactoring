package com.mehdirefactoring.com.thisisrefactoring.service;

import com.mehdirefactoring.com.thisisrefactoring.notification.*;
import com.mehdirefactoring.com.thisisrefactoring.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.repository.BlogPostRepository;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;





    // Extract Function Refactoring technique
    public void createOrUpdateBlogPost(BlogPost blogPost) {
        validateBlogPost(blogPost);

        if (blogPost.getId() == null) {
            createBlogPost(blogPost);
        } else {
            updateBlogPost(blogPost);
        }
    }

    private void validateBlogPost(BlogPost blogPost) {
        // Introduce Utility Method to avoid duplicated validation logic
        ValidationUtil.validateStringLength(blogPost.getTitle().getValue(), 100,
                "Title cannot exceed 100 characters");    }

    private void createBlogPost(BlogPost blogPost) {
        blogPostRepository.save(blogPost);
    }

    private void updateBlogPost(BlogPost blogPost) {
        BlogPost existingPost = blogPostRepository.findById(blogPost.getId()).orElse(null);
        if (existingPost == null) {
            throw new IllegalArgumentException("Blog post not found for update");
        }

        existingPost.setTitle(blogPost.getTitle());
        existingPost.setContent(blogPost.getContent());
        existingPost.setAuthor(blogPost.getAuthor());
        existingPost.setCategory(blogPost.getCategory());
        blogPostRepository.save(existingPost);
    }

    // Move Function Refactoring technique
    public void incrementBlogPostViews(Long id) {
        BlogPost blogPost = blogPostRepository.findById(id).get();
        blogPost.incrementViews();
        blogPostRepository.save(blogPost);
    }


    public BlogPost publishBlogPost(BlogPost blogPost) {
        // Magic Number code smell
        if (blogPost.getContent().length() < 100) { // Magic number: 100
            throw new IllegalArgumentException("Content must be at least 100 characters long");
        }
        // Save the blog post
        BlogPost savedPost = blogPostRepository.save(blogPost);

        // Observer Pattern
        // Use NotificationManager to decouple notification logic
        List<Notification> notifications = List.of(
                new EmailNotification(),
                new SmsNotification(),
                new PushNotification()
        );
        NotificationManager notificationManager = new NotificationManager(notifications);
        notificationManager.notifyAll(savedPost);

        return savedPost;
    }

    public BlogPost processAndSaveBlogPost(BlogPost blogPost) {
        //  Inline Variable Refactoring technique
        blogPost.setContent(formatBlogPostContent(blogPost));
        return blogPostRepository.save(blogPost);
    }

    private String formatBlogPostContent(BlogPost blogPost) {
        // Just an example of formatting logic
        return blogPost.getContent().toUpperCase();
    }


    public List<BlogPost> getAllBlogs() {
        return blogPostRepository.findAll();
    }

    public BlogPost getBlogById(Long id) {
        return blogPostRepository.findById(id).orElse(null);
    }

    public void deleteBlog(Long id) {
        blogPostRepository.deleteById(id);
    }
}
