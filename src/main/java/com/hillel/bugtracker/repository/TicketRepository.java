package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Ticket;

import java.util.List;

public interface TicketRepository {
    List<Ticket> getTicketList();
    Ticket getTicketById(int id);
    void save (Ticket ticket);
    void update (Ticket ticket);
    void delete (int id);
}
