package com.mehdirefactoring.com.thisisrefactoring.repository;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import com.mehdirefactoring.com.thisisrefactoring.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    public List<Comment> findByBlogPostId(Long blogPost);

}
