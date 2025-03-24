package com.example.bai_1_spring_mvc.service;

import com.example.bai_1_spring_mvc.model.Student;
import com.example.bai_1_spring_mvc.repository.IStudentRepository;
import com.example.bai_1_spring_mvc.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;
    @Override
    public List<Student> getStudent() {
        return studentRepository.getStudent();
    }

    @Override
    public void addStudent(Student student) {
         studentRepository.addStudent(student);
    }

    @Override
    public boolean deleteStudent(int id) {
        return studentRepository.deleteStudent(id);
    }

    @Override
    public Student findStudent(int id) {
        List<Student> studentList = studentRepository.getStudent();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId()==id){
                return studentList.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean editStudent(int id, Student student) {
        Student student1= findStudent(id);
        if (student1!=null){
            studentRepository.editStudent(id,student);
            return true;
        }
        return false;
    }

    @Override
    public List<Student> searchStudent(String name) {
        return studentRepository.searchStudent(name);
    }
}
