package com.hillel.bugtracker.repository;


import com.hillel.bugtracker.model.MessageEntity;
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
    public void saveMessage(MessageEntity messageEntity) {
        getCurrentSession().saveOrUpdate(messageEntity);
    }

    @Override
    public void updateMessage(MessageEntity messageEntity) {
        getCurrentSession().getTransaction().commit();
    }

    @Override
    public void deleteMessage(int id) {
        MessageEntity messageEntity = getCurrentSession().get(MessageEntity.class, id);
        getCurrentSession().delete(messageEntity);
    }
}
