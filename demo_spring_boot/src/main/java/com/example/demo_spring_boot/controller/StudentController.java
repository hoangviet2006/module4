package com.example.demo_spring_boot.controller;

import com.example.demo_spring_boot.model.Student;
import com.example.demo_spring_boot.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private IStudentService studentService;
    @GetMapping("")
    public String getAll(Model model){
        List<Student> students = studentService.findAll();
        model.addAttribute("studentList",studentService.findAll());
        return "/student/list";
    }
}
