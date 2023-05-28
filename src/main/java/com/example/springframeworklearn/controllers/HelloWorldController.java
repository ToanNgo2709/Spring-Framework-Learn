package com.example.springframeworklearn.controllers;

import com.example.springframeworklearn.models.entities.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("hello-world")
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping("hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello World");
    }
}
