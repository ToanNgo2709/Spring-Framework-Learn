package com.example.springframeworklearn.repositories;

import com.example.springframeworklearn.models.entities.User;

import java.util.List;

public interface UserServiceLogic {
    public List<User> getAll();
    public User deleteUser(int id);
    public User findById(Integer id);
    public User save(User user);
}
