package com.example.springframeworklearn.controllers;

import com.example.springframeworklearn.constants.ApiUrl;
import com.example.springframeworklearn.models.entities.User;
import com.example.springframeworklearn.repositories.UserServiceLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(ApiUrl.USER_API)
public class UserController {
    UserServiceLogic userServiceLogic;

    public UserController(UserServiceLogic userServiceLogic) {
        this.userServiceLogic = userServiceLogic;
    }

    @GetMapping
    public List<User> getAllUser() {
        return userServiceLogic.getAll();
    }
}
