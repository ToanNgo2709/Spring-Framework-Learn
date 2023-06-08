package com.example.springframeworklearn.services;

import com.example.springframeworklearn.models.entities.User;
import com.example.springframeworklearn.repositories.UserServiceLogic;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class UserServiceLogicImpl implements UserServiceLogic {

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "toanngo", LocalDate.now().minusYears(30)));
        users.add(new User(2, "ngo toan", LocalDate.now().minusYears(25)));
        users.add(new User(3, "John doe", LocalDate.now().minusYears(20)));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public User deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
        return null;
    }

    @Override
    public User findById(Integer id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }
}
