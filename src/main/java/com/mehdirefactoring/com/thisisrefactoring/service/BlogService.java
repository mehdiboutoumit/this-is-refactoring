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
