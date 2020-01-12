package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
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
    public List<UserEntity> getUserList() {
        return getCurrentSession().createQuery("from UserEntity", UserEntity.class).list();
    }

    @Override
    public UserEntity getUserById(int id) {
        return getCurrentSession().get(UserEntity.class, id);
    }

    @Override
    public void save(UserEntity userEntity) {
        getCurrentSession().saveOrUpdate(userEntity);
    }


    @Override
    public void delete(int id) {
        UserEntity userEntity = getUserById(id);
        getCurrentSession().delete(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("from UserEntity where email = :email");
        query.setParameter("email", email);

        try {
            UserEntity userEntity = (UserEntity) query.getSingleResult();
            return userEntity;
        } catch (NoResultException e) {
            return null;
        }
    }
}
