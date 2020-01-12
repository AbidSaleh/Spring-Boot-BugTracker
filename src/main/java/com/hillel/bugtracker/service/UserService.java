package com.hillel.bugtracker.service;


import com.hillel.bugtracker.model.UserEntity;

import java.util.List;

public interface UserService {

    void addUser(UserEntity userEntity);

    List<UserEntity> getUsers();

    UserEntity getUser(int id);

    void updateUser(UserEntity userEntity);

    void deleteUser(int id);

    UserEntity findByUsername(String email);
}
