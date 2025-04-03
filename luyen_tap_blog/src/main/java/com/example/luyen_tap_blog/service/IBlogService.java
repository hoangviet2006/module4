package com.example.luyen_tap_blog.service;

import com.example.luyen_tap_blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
        List<Blog> getBlog();
        List<Blog> findFalse();
        void addBlog(Blog blog);
        Blog findId(long id);
        boolean updateBlog(long id,Blog blog);
        boolean deleteBlog(long id);
        Page<Blog> searchByName(String name, Pageable pageable);
        void save(Blog blog);
        List<Blog> findByName(String name);

}
