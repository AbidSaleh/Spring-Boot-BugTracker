package com.hillel.bugtracker.repository;


import com.hillel.bugtracker.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MessageRepositoryImpl implements MessageRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveMessage(Message message) {
        getCurrentSession().saveOrUpdate(message);
    }

    @Override
    public void updateMessage(Message message) {
        getCurrentSession().getTransaction().commit();
    }

    @Override
    public void deleteMessage(int id) {
        Message message = getCurrentSession().get(Message.class, id);
        getCurrentSession().delete(message);
    }
}
