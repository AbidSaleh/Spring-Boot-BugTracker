package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    List<Ticket> getTickets();

    Ticket getTicket(int id);

    void updateTicket(Ticket ticket);

    void deleteTicket(int id);

    void addMessage(int ticketId, Message message);

    void updateMessage(int ticketId, Message message);


}
