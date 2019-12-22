package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userRepository.getUserList();
    }

    @Transactional
    @Override
    public User getUser(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.delete(id);
    }
}
