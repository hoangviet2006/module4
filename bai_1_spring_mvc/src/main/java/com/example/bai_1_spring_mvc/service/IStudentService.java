package com.example.bai_1_spring_mvc.service;

import com.example.bai_1_spring_mvc.model.Student;
import com.example.bai_1_spring_mvc.repository.IStudentRepository;
import com.example.bai_1_spring_mvc.repository.StudentRepository;

import java.util.List;

public interface IStudentService {
    List<Student> getStudent();
    void addStudent(Student student);
    boolean deleteStudent(int id);
    Student findStudent(int id);
    boolean editStudent(int id, Student student);
    List<Student> searchStudent(String name);

}
