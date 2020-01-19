package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.MessageEntity;
import com.hillel.bugtracker.model.TicketEntity;

import java.util.List;

public interface TicketService {

    void addTicket(TicketEntity ticketEntity);

    List<TicketEntity> getTickets();

    TicketEntity getTicket(int id);

    void updateTicket(TicketEntity ticketEntity);

    void deleteTicket(int id);

    void addMessage(MessageEntity messageEntity);

    void updateMessage(MessageEntity messageEntity);

    void deleteMessage(int id);

    List<TicketEntity> findUsersTickets(int userId);

}
