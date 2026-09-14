package com.microservices.learning.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Microservices Learning Application!";
    }

    @GetMapping("/status")
    public String status() {
        return "Application is running successfully on port 8080";
    }
}