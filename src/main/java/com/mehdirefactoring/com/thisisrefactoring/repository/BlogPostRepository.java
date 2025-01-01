package com.mehdirefactoring.com.thisisrefactoring.repository;

import com.mehdirefactoring.com.thisisrefactoring.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

}
