package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.TicketEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
    public List<TicketEntity> getTicketList() {
        return getCurrentSession().createQuery("from TicketEntity", TicketEntity.class).list();
    }

    @Override
    public TicketEntity getTicketById(int id) {

        /*Query<TicketEntity> query = sessionFactory.getCurrentSession().createQuery(
                "select t from TicketEntity t " +
                        "JOIN FETCH t.messages " +
                        "where t.ticketId = :id",
                TicketEntity.class);
        query.setParameter("id", id);
        TicketEntity ticketEntity = query.getSingleResult();*/

        TicketEntity ticketEntity = getCurrentSession().get(TicketEntity.class, id);

        return ticketEntity;
    }

    @Override
    public void save(TicketEntity ticketEntity) {
        getCurrentSession().saveOrUpdate(ticketEntity);
    }

    @Override
    public void delete(int id) {
        TicketEntity ticketEntity = getTicketById(id);
        getCurrentSession().delete(ticketEntity);
    }

}
