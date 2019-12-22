package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Transactional
@Repository
public class TicketRepositoryImpl implements TicketRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Ticket> getTicketList() {
        return getCurrentSession().createQuery("from Ticket", Ticket.class).list();
    }

    @Override
    public Ticket getTicketById(int id) {
        return getCurrentSession().get(Ticket.class, id);
    }

    @Override
    public void save(Ticket ticket) {
        getCurrentSession().saveOrUpdate(ticket);
    }

    @Override
    public void delete(int id) {
        Ticket ticket = getTicketById(id);
        getCurrentSession().delete(ticket);
    }

    @Override
    public void saveMessage(Message message) {
        if (getTicketById(message.getTicketId()).getMessages() == null) {
            getTicketById(message.getTicketId()).setMessages(new HashMap<>());
        }
        getCurrentSession().saveOrUpdate(message);
    }
}
