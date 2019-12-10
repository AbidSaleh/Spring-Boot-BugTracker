package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.getTicketList();
    }

    @Override
    public Ticket getTicket(int id) {
        return ticketRepository.getTicketById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.update(ticket);
    }

    @Override
    public void deleteTicket(int id) {
        ticketRepository.delete(id);
    }

    @Override
    public void addMessage(int ticketId, Message message) {
        ticketRepository.saveMessage(ticketId, message);
    }

    @Override
    public void updateMessage(int ticketId, Message message) {
        ticketRepository.saveMessage(ticketId, message);
    }
}
