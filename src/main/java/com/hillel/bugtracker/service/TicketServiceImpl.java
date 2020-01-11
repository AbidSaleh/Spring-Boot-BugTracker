package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.repository.MessageRepository;
import com.hillel.bugtracker.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void addTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public List<Ticket> getTickets() {
        return ticketRepository.getTicketList();
    }

    @Transactional
    @Override
    public Ticket getTicket(int id) {
        return ticketRepository.getTicketById(id);
    }

    @Override
    public void updateTicket(Ticket ticket) {
        ticketRepository.save(ticket);
    }

    @Transactional
    @Override
    public void deleteTicket(int id) {
        ticketRepository.delete(id);
    }

    @Override
    public void addMessage(Message message) {
        messageRepository.saveMessage(message);
        updateTicket(message.getTicket());
    }

    @Override
    public void updateMessage(Message message) {
        messageRepository.saveMessage(message);
        updateTicket(message.getTicket());
    }

    @Transactional
    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteMessage(id);
    }
}
