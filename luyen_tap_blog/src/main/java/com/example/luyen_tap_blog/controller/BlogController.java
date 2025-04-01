package com.example.luyen_tap_blog.controller;

import com.example.luyen_tap_blog.model.Author;
import com.example.luyen_tap_blog.model.Blog;
import com.example.luyen_tap_blog.service.IAuthorService;
import com.example.luyen_tap_blog.service.IBlogService;
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
    private IAuthorService authorService;
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String getBlog(@RequestParam(required = false, defaultValue = "")
                          String name,
                          Model model,
                          @PageableDefault(size = 2)
                          Pageable pageable) {
        Page<Blog> blogPage = blogService.searchByName(name, pageable);
        model.addAttribute("blogPage", blogPage);
        model.addAttribute("name", name);
        return "/views/list";
    }

    @GetMapping("/create")
    public String formCreate(Model model) {
        List<Author> getAuthor = authorService.findAlLAuthor();
        model.addAttribute("author", getAuthor);
        model.addAttribute("blog", new Blog());
        return "/views/create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute Blog blog) {
        blogService.addBlog(blog);
        return "redirect:/blog";
    }

    @GetMapping("/update")
    public String formUpdate(Model model, @RequestParam("id") long id) {
        Blog blog = blogService.findId(id);
        model.addAttribute("findBlog", blog);
        List<Author> authors = authorService.findAlLAuthor();
        model.addAttribute("author", authors);
        return "/views/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Blog blog, @RequestParam("id") long id) {
        blogService.updateBlog(id, blog);
        return "redirect:/blog";
    }

    @GetMapping("/delete")
    public String deleteBlog(@RequestParam("id") long id) {
        blogService.deleteBlog(id);
        return "redirect:/blog";
    }

}
