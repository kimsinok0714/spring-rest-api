package com.example.spring_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_rest_api.entity.Student;
import com.example.spring_rest_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @GetMapping("/students")
    public List<Student> getStudents() {
        return studentService.getStudentAll();
    }

}
