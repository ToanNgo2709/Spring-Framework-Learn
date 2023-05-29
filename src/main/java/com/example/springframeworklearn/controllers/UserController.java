package com.example.springframeworklearn.controllers;

import com.example.springframeworklearn.advices.exceptions.UserNotFoundException;
import com.example.springframeworklearn.constants.ApiUrl;
import com.example.springframeworklearn.models.entities.User;
import com.example.springframeworklearn.repositories.UserServiceLogic;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user =  userServiceLogic.findById(id);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK).getBody();
    }

    @PostMapping
    public ResponseEntity<URI> saveUser(@RequestBody User user) {
        userServiceLogic.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }
}
