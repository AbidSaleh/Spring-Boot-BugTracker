package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.UserEntity;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getUserList();

    UserEntity getUserById(int id);

    void save(UserEntity userEntity);

    void delete(int id);

    UserEntity findByEmail(String username);

}
