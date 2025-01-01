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
