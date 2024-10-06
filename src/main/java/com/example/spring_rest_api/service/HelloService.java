package com.example.spring_rest_api.service;

import org.springframework.stereotype.Service;

import com.example.spring_rest_api.repository.StudentRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class HelloService {

    private final  StudentRepository studentRepository;

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
