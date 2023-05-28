package com.example.springframeworklearn.controllers;

import com.example.springframeworklearn.models.section1.restapi.Course;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CourseController {

    @GetMapping("/course")
    public List<Course> retrieveAllCourse() {
        return Arrays.asList(
                new Course(1, "Learn AWS", "in28minute"),
                new Course(2, "Learn Java", "in28minute"),
                new Course(3, "Learn DevOps", "in28minute")
        );
    }
}
