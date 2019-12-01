package com.hillel.bugtracker.service;


import com.hillel.bugtracker.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getUsers();

    User getUser(int id);

    void updateUser(User user);

    void deleteUser(int id);
}
