package com.example.blog.service;

import com.example.blog.dto.BlogDto;
import com.example.blog.exception.NameException;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.repository.IAuthorRepository;
import com.example.blog.repository.IBlogRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private IAuthorRepository authorRepository;

    @Override
    public List<Blog> getBlog() {
        return blogRepository.findAll();
    }

    @Override
    public void addBlog(BlogDto blogDto)  {
        Author author = authorRepository.findFirstByNameAuthorContaining(blogDto.getNameAuthor());
        if (author == null) {
            author = new Author();
            author.setNameAuthor(blogDto.getNameAuthor());
            author.setBirthDate(blogDto.getBirthDate());
            author = authorRepository.saveAndFlush(author);
        }
        Blog blog = new Blog();
        blog.setCode(blogDto.getCode());
        blog.setName(blogDto.getNameBlog());
        blog.setGenre(blogDto.getGenre());
        blog.setQuantity(blogDto.getQuantity());
        blog.setIdAuthor(author);
        if (blog.getName().equals("Hoang Viet")){
            try {
                throw new NameException("Tên trùng với admin");
            } catch (NameException e) {
                throw new RuntimeException(e);
            }
        }
        blogRepository.save(blog);
    }

    @Override
    public boolean updateBlog(long id, Blog blog) {
        Blog updateBlog = blogRepository.findBlogsById(id);
        if (updateBlog != null) {
            updateBlog.setCode(blog.getCode());
            updateBlog.setName(blog.getName());
            updateBlog.setGenre(blog.getGenre());
            updateBlog.setQuantity(blog.getQuantity());
            updateBlog.setIdAuthor(blog.getIdAuthor());
        }
        blogRepository.save(updateBlog);
        return true;
    }

    @Override
    public boolean deleteBlog(long id) {
        Blog deleteBlog = blogRepository.findBlogsById(id);
        if (deleteBlog.getDeleted() == false) {
            deleteBlog.setDeleted(true);
            blogRepository.save(deleteBlog);
            return true;
        }
        return false;
    }

    @Override
    public Blog findById(long id) {
        return blogRepository.findBlogsById(id);
    }

    @Override
    public Page<Blog> searchBlogByName(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

}
