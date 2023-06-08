package com.example.springframeworklearn.controllers;

import com.example.springframeworklearn.advices.exceptions.UserNotFoundException;
import com.example.springframeworklearn.constants.ApiUrl;
import com.example.springframeworklearn.models.entities.User;
import com.example.springframeworklearn.repositories.UserServiceLogic;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        User user =  userServiceLogic.findById(id);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK).getBody();
    }

    @PostMapping
    public ResponseEntity<URI> saveUser(@Valid @RequestBody User user) {
        userServiceLogic.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return new ResponseEntity<>(location, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public User deleteUser(@PathVariable int id) {
        User user =  userServiceLogic.deleteUser(id);
        if(user == null) {
            throw new UserNotFoundException("User not found");
        }
        return new ResponseEntity<>(user, HttpStatus.OK).getBody();
    }
}
