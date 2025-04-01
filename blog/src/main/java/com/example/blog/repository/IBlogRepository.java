package com.example.blog.repository;

import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    Blog findBlogsById(long id);
    Page<Blog> findByNameContaining(String name, Pageable pageable);

}
