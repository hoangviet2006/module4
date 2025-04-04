package com.example.luyen_tap_blog.controller;

import com.example.luyen_tap_blog.dto.BlogDto;
import com.example.luyen_tap_blog.model.Author;
import com.example.luyen_tap_blog.model.Blog;
import com.example.luyen_tap_blog.service.IAuthorService;
import com.example.luyen_tap_blog.service.IBlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/blogs")
public class RestBlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IAuthorService authorService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> getBlog() {
        List<Blog> blogs = blogService.findFalse();
        if (blogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//204
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);//200
    }

    @PostMapping("")
    public ResponseEntity<?> add(@RequestBody BlogDto blogDto) {
        Author author = authorService.findById(blogDto.getIdAuthor().getId());
        if (author == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Blog blog = new Blog();
        BeanUtils.copyProperties(blogDto, blog);
        blogService.save(blog);
        return new ResponseEntity<>("Thêm Mới Thành Công", HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Blog blog = blogService.findId(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.deleteBlog(id);
        return new ResponseEntity<>("Xóa thành công", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getId(@PathVariable("id") int id) {
        Blog blog = blogService.findId(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody BlogDto blogDto) {
        Blog blog = blogService.findId(id);
        if (blog != null) {
            BeanUtils.copyProperties(blogDto, blog);
            blogService.save(blog);
            blogService.updateBlog(id, blog);
            return new ResponseEntity<>("Chỉnh Sửa thành công", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/author/{nameAuthor}")
    public ResponseEntity<?> getAuthor(@PathVariable("nameAuthor") String nameAuthor) {
        List<Author> author = authorService.findByName(nameAuthor);
        if (author.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(author, HttpStatus.OK);
    }

    @PostMapping("/author")
    public ResponseEntity<?> addAuthor(@RequestBody Author author) {
        authorService.addAuthor(author);
        return new ResponseEntity<>("Thêm mới tác giả thành công", HttpStatus.OK);
    }

    @GetMapping("/author")
    public ResponseEntity<List<Author>> getAuthor() {
        List<Author> authors = authorService.findAlLAuthor();
        if (authors.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @GetMapping("/search/{name}")
    public ResponseEntity<List<Blog>> getNameBlog(@PathVariable("name") String name) {
        List<Blog> blog = blogService.findByName(name);
        if (blog.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
