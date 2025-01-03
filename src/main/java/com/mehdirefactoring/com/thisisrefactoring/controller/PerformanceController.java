package com.mehdirefactoring.com.thisisrefactoring.controller;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import com.mehdirefactoring.com.thisisrefactoring.service.BlogService;
import com.mehdirefactoring.com.thisisrefactoring.service.CommentService;
import com.mehdirefactoring.com.thisisrefactoring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/performance")
public class PerformanceController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    // Test the performance of creating or updating blog posts
    @PostMapping("/test/blog-post")
    public ResponseEntity<String> testBlogPostPerformance(@RequestParam int count) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            BlogPost post = new BlogPost("Title " + i, "Content " + i, "Author " + i);
            blogService.createOrUpdateBlogPost(post);
        }

        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Processed " + count + " blog posts in " + (endTime - startTime) + " ms");
    }

    // Test the performance of adding comments
    @PostMapping("/test/comment")
    public ResponseEntity<String> testCommentPerformance(@RequestParam int count) {
        long startTime = System.currentTimeMillis();

        BlogPost samplePost = new BlogPost("Sample Title", "Sample Content", "Sample Author");
        blogService.createOrUpdateBlogPost(samplePost);

        for (int i = 0; i < count; i++) {
            Comment comment = new Comment(samplePost.getId(), "Author " + i, "Content " + i);
            commentService.addComment(comment);
        }

        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Processed " + count + " comments in " + (endTime - startTime) + " ms");
    }

    // Test the performance of user creation
    @PostMapping("/test/user")
    public ResponseEntity<String> testUserCreationPerformance(@RequestParam int count) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < count; i++) {
            userService.createUser("User" + i, "user" + i + "@example.com");
        }

        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Processed " + count + " user creations in " + (endTime - startTime) + " ms");
    }

    // Test fetching all blog posts
    @GetMapping("/test/fetch-blogs")
    public ResponseEntity<String> testFetchAllBlogs() {
        long startTime = System.currentTimeMillis();

        blogService.getAllBlogs();

        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Fetched all blogs in " + (endTime - startTime) + " ms");
    }

    // Test fetching all comments for a blog post
    @GetMapping("/test/fetch-comments")
    public ResponseEntity<String> testFetchAllComments(@RequestParam Long blogPostId) {
        long startTime = System.currentTimeMillis();

        commentService.getAllCommentsForPost(blogPostId);

        long endTime = System.currentTimeMillis();
        return ResponseEntity.ok("Fetched all comments for blog post in " + (endTime - startTime) + " ms");
    }
}

