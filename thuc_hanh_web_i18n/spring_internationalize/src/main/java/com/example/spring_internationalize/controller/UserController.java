package com.example.spring_internationalize.controller;

import com.example.spring_internationalize.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {
    @GetMapping("")
    public String formCrete(Model model){
        model.addAttribute("user",new User());
        return "/../views/login";
    }
}
