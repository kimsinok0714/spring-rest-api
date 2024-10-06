package com.example.spring_rest_api.service;

import org.springframework.stereotype.Service;


@Service
public class HelloService {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
