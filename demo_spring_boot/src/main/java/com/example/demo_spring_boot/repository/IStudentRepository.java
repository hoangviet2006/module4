package com.example.demo_spring_boot.repository;

import com.example.demo_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findStudentByIdContainsAndName(int id, String name);
}
