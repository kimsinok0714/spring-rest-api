package com.example.spring_rest_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spring_rest_api.entity.Student;
import com.example.spring_rest_api.repository.StudentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<Student> getStudentAll() {
       return studentRepository.findAll();
    }

}
