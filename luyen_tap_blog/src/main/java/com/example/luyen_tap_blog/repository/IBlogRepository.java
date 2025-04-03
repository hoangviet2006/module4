package com.example.luyen_tap_blog.repository;

import com.example.luyen_tap_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogById(long id);
    List<Blog> findByDeletedFalse();
    Page<Blog> findByNameBlogContainingIgnoreCaseAndDeletedFalse(String name, Pageable pageable);

    List<Blog> findByNameBlog(String nameBlog);
}
