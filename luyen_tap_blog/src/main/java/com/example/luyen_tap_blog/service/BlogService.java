package com.example.luyen_tap_blog.service;

import com.example.luyen_tap_blog.model.Blog;
import com.example.luyen_tap_blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;


    @Override
    public List<Blog> getBlog() {
       return blogRepository.findAll();
    }

    @Override
    public List<Blog> findFalse() {
        return blogRepository.findByDeletedFalse();
    }

    @Override
    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findId(long id) {
        return blogRepository.findBlogById(id);
    }

    @Override
    public boolean updateBlog(long id, Blog blog) {
        Blog blog1 = blogRepository.findBlogById(id);
        if (blog1 != null) {
            blog1.setCode(blog.getCode());
            blog1.setNameBlog(blog.getNameBlog());
            blog1.setGenre(blog.getGenre());
            blog1.setQuantity(blog.getQuantity());
            blog1.setIdAuthor(blog.getIdAuthor());
        }
        blogRepository.save(blog1);
        return true;
    }

    @Override
    public boolean deleteBlog(long id) {
        Blog blog = blogRepository.findBlogById(id);
        if (blog.getDeleted() == false) {
            blog.setDeleted(true);
        }
        blogRepository.save(blog);
        return true;
    }

    @Override
    public Page<Blog> searchByName(String name, Pageable pageable) {
        return blogRepository.findByNameBlogContainingIgnoreCaseAndDeletedFalse(name,pageable);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> findByName(String name) {
        return blogRepository.findByNameBlog(name);
    }
}
