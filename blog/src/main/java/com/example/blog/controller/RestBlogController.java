package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.repository.IAuthorRepository;
import com.example.blog.repository.IBlogRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private IAuthorRepository authorRepository;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlog() {
        List<Blog> blogs = blogRepository.findAll();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);//200
    }

        @PostMapping("")
        public ResponseEntity<?> create(@RequestBody BlogDto blogDto) {
            Author author = authorRepository.findAuthorsById(blogDto.getIdAuthor().getId());
            if (author == null) {
                author = new Author();
                author.setNameAuthor(blogDto.getNameAuthor());
                author.setBirthDate(blogDto.getIdAuthor().getBirthDate());
                author = authorRepository.saveAndFlush(author);
            }
            Blog blog = new Blog();
            BeanUtils.copyProperties(blogDto,blog,"idAuthor");
            blog.setIdAuthor(author);
            blogRepository.save(blog);
            return new ResponseEntity<>("Thêm Mới Thành Công",HttpStatus.CREATED);
        }
}
