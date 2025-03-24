package com.example.bai_1_spring_mvc.controller;

import com.example.bai_1_spring_mvc.model.Student;
import com.example.bai_1_spring_mvc.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private IStudentService service;

    @GetMapping("/student")
    public String listStudent(Model model) {
        List<Student> studentList = service.getStudent();
        model.addAttribute("studentList", studentList);
        return "/student/list";
    }

    @GetMapping("/student/create")
    public String formCreate() {
        return "/student/create";
    }

    @PostMapping("/student/create")
    public String saveCreate(@RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        List<Student> studentList = service.getStudent();
        int id = studentList.size() + 1;
        Student student = new Student(id, name);
        service.addStudent(student);
        redirectAttributes.addFlashAttribute("message", "Thêm mới sinh viên thành công!");
        return "redirect:/student";
    }

    @GetMapping("/student/delete")
    public String deleteStudent(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        service.deleteStudent(id);
        redirectAttributes.addFlashAttribute("message", "Xóa sinh viên thành công!");
        return "redirect:/student";
    }

    @GetMapping("/student/edit")
    public String formEditStudent(@RequestParam("id") int id, Model model) {
        Student student = service.findStudent(id);
        model.addAttribute("editStudent", student);
        return "/student/edit";
    }

    @PostMapping("/student/edit")
    public String EditStudent(@RequestParam("id") int id, @RequestParam("name") String name, RedirectAttributes redirectAttributes) {
        Student student = new Student(id, name);
        service.editStudent(id, student);
        redirectAttributes.addFlashAttribute("message", "Cập nhật thông tin sinh viên thành công!");
        return "redirect:/student";
    }
    @PostMapping("/student/search")
    public String searchStudent(@RequestParam("name") String name,Model model){
        List<Student> studentList = service.searchStudent(name);
        model.addAttribute("studentList",studentList);
        return "/student/list";
    }
}
