package com.example.demo_spring_boot.service;

import com.example.demo_spring_boot.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();
}
