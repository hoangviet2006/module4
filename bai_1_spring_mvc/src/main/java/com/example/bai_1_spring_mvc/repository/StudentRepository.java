package com.example.bai_1_spring_mvc.repository;

import com.example.bai_1_spring_mvc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"Việt"));
        studentList.add(new Student(2,"Đạt"));
        studentList.add(new Student(3,"Quốc"));
    }
    @Override
    public List<Student> getStudent() {
        return studentList;
    }

    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()==id){
                studentList.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editStudent(int id, Student student) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()==id){
                studentList.set(i,student);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Student> searchStudent(String name) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                students.add(studentList.get(i));
            }
        }
        return students;
    }
}
