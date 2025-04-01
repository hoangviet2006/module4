package com.example.luyen_tap_blog.repository;

import com.example.luyen_tap_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(long id);

    Page<Blog> findByNameContainingIgnoreCaseAndDeletedFalse(String name, Pageable pageable);

}
