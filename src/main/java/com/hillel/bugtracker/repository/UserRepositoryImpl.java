package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getUserList() {
        return getCurrentSession().createQuery("from User", User.class).list();
    }

    @Override
    public User getUserById(int id) {
        return getCurrentSession().get(User.class, id);
    }

    @Override
    public void save(User user) {
        getCurrentSession().saveOrUpdate(user);
    }


    @Override
    public void delete(int id) {
        User user = getUserById(id);
        getCurrentSession().delete(user);
    }
}
