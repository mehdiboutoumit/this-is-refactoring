package com.mehdirefactoring.com.thisisrefactoring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.repository.BlogPostRepository;

import java.util.List;

@Service
public class BlogService {

    @Autowired
    private BlogPostRepository blogPostRepository;

    @Autowired
    private NotificationService notificationService;

    // Long Method Smell: handling both creation and update logic in one method
    public void createOrUpdateBlogPost(BlogPost blogPost) {
        if (blogPost.getTitle().length() > 100) {  // Duplicated logic for length validation
            throw new IllegalArgumentException("Title cannot exceed 100 characters");
        }
        if (blogPost.getId() == null) {
            blogPostRepository.save(blogPost);
        } else {
            BlogPost existingPost = blogPostRepository.findById(blogPost.getId()).orElse(null);
            if (existingPost != null) {
                existingPost.setTitle(blogPost.getTitle());
                existingPost.setContent(blogPost.getContent());
                existingPost.setAuthor(blogPost.getAuthor());
                existingPost.setCategory(blogPost.getCategory());
                blogPostRepository.save(existingPost);
            }
        }
    }

    // Feature envy: The service is directly manipulating the domain object
    public void updateBlogPostAuthor(Long id, String author) {
        BlogPost blogPost = blogPostRepository.findById(id).get();
        blogPost.setAuthor(author);
        blogPost.setViews(blogPost.getViews() + 10); // Feature envy: should be done in BlogPost class
        blogPostRepository.save(blogPost);
    }

    // Shotgun Surgery code smell
    // If we add a new type of notification we need to apply the changes
    // in too many places
    public BlogPost publishBlogPost(BlogPost blogPost) {
        // Magic Number code smell
        if (blogPost.getContent().length() < 100) { // Magic number: 100
            throw new IllegalArgumentException("Content must be at least 100 characters long");
        }
        // Save the blog post
        BlogPost savedPost = blogPostRepository.save(blogPost);

        // Lack of Separation of Concerns
        // Explicitly call each notification method (Shotgun Surgery)
        notificationService.sendEmailNotification(savedPost);
        notificationService.sendSmsNotification(savedPost);
        notificationService.sendPushNotification(savedPost);

        return savedPost;
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
