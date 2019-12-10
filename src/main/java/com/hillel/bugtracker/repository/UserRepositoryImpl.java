package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private int currentUserId = 1;
    private Map<Integer, User> userMap = new ConcurrentHashMap<>();

    @Override
    public List<User> getUserList() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User getUserById(int id) {
        return userMap.get(id);
    }

    @Override
    public void save(User user) {
        if (userMap.get(user.getUserId()) == null) {
            user.setUserId(currentUserId);
            currentUserId++;
        }
        userMap.put(user.getUserId(), user);
    }

    @Override
    public void update(User user) {
        userMap.put(user.getUserId(), user);
    }


    @Override
    public void delete(int id) {
        userMap.remove(id);

    }
}
