package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlog();
    void  addBlog(BlogDto blogDto);
    boolean updateBlog(long id,Blog blog);
    boolean deleteBlog(long id);
    Blog findById(long id);
    Page<Blog> searchBlogByName(String name, Pageable pageable);
}
