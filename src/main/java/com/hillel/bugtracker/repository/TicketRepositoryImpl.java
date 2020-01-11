package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

        Query<Ticket> query = sessionFactory.getCurrentSession().createQuery(
                "select t from Ticket t " +
                        "JOIN FETCH t.messages " +
                        "where t.ticketId = :id",
                Ticket.class);
        query.setParameter("id", id);
        Ticket ticket = query.getSingleResult();

        return ticket;
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

}
