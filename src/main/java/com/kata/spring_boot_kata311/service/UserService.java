package com.kata.spring_boot_kata311.service;

import com.kata.spring_boot_kata311.model.User;


import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();

    User show(int id);

    void update(int id, User updatedUser);

    void delete(int id);

}
