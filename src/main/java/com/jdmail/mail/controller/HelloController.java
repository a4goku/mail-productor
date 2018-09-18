package com.jdmail.mail.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot Demo! I am learning JD mail system!";
    }
}
