package com.example.bai_1_spring_mvc.repository;

import com.example.bai_1_spring_mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getStudent();
    void addStudent(Student student);
    boolean deleteStudent(int id);
    boolean editStudent(int id, Student student);
    List<Student> searchStudent(String name);

}
