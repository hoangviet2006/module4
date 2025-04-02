package com.example.blog.controller;

import com.example.blog.dto.BlogDto;
import com.example.blog.model.Author;
import com.example.blog.model.Blog;
import com.example.blog.service.IAuthorService;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IAuthorService authorService;

    //    @GetMapping("")
//    public String getBlog(Model model) {
//        List<Blog> blog = blogService.getBlog();
//        model.addAttribute("getBlog", blog);
//        return "/views/list";
//    }
    @GetMapping("")
        public String search(@RequestParam(required = false, defaultValue = "") String name,
                         Model model,
                         @PageableDefault(size = 2) Pageable pageable) {
        Page<Blog> blogPage = blogService.searchBlogByName(name, pageable);
        model.addAttribute("getBlog",blogPage);
        model.addAttribute("name",name);
        return "/views/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        List<Author> authors = authorService.getAuthor();
        model.addAttribute("authors", authors);
        model.addAttribute("blogDto", new BlogDto());
        return "/views/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute BlogDto blog) {
        blogService.addBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String formUpdate(Model model, @RequestParam("id") long id) {
        Blog blog = blogService.findById(id);
        model.addAttribute("findBlog", blog);
        List<Author> author = authorService.findAllAuthor();
        model.addAttribute("author", author);
        return "/views/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog) {
        blogService.updateBlog(blog.getId(), blog);
        return "redirect:/blog";
    }

}
