package com.example.spring_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.spring_rest_api.entity.Student;
import com.example.spring_rest_api.service.StudentService;
import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    /*
     * 전체 학생 목록 조회
     * GET /students
     * 200 OK
     */
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudentAll());
    }

}

