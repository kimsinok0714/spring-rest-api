package com.example.spring_rest_api.controller;

import org.springframework.web.bind.annotation.RestController;
import com.example.spring_rest_api.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequiredArgsConstructor
public class HelloController {

    private final HelloService helloService;

    @GetMapping("/message")
    public String messge() {
        helloService.setMessage("<h1>Hello, Spring Book</h1>");
        return helloService.getMessage(); 
    }

}




