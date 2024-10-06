package com.example.spring_rest_api.service;

import java.util.List;

import com.example.spring_rest_api.entity.Student;

public interface StudentService {
    
    List<Student> getStudentAll();

    Student getStudentByStudntId(Long studentId);

    Student addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);

}
