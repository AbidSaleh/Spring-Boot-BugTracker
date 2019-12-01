package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getUserList();
    User getUserById(int id);
    void save (User user);
    void update (User user);
    void delete (int id);

}
