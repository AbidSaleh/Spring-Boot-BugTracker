package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.TicketEntity;

import java.util.List;

public interface TicketRepository {
    List<TicketEntity> getTicketList();

    TicketEntity getTicketById(int id);

    void save(TicketEntity ticketEntity);

    void delete(int id);
}
