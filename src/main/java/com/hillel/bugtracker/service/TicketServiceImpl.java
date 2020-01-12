package com.hillel.bugtracker.service;

import com.hillel.bugtracker.model.MessageEntity;
import com.hillel.bugtracker.model.TicketEntity;
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
    public void addTicket(TicketEntity ticketEntity) {
        ticketRepository.save(ticketEntity);
    }

    @Transactional
    @Override
    public List<TicketEntity> getTickets() {
        return ticketRepository.getTicketList();
    }

    @Transactional
    @Override
    public TicketEntity getTicket(int id) {
        return ticketRepository.getTicketById(id);
    }

    @Override
    public void updateTicket(TicketEntity ticketEntity) {
        ticketRepository.save(ticketEntity);
    }

    @Transactional
    @Override
    public void deleteTicket(int id) {
        ticketRepository.delete(id);
    }

    @Override
    public void addMessage(MessageEntity messageEntity) {
        messageRepository.saveMessage(messageEntity);
        updateTicket(messageEntity.getTicket());
    }

    @Override
    public void updateMessage(MessageEntity messageEntity) {
        messageRepository.saveMessage(messageEntity);
        updateTicket(messageEntity.getTicket());
    }

    @Transactional
    @Override
    public void deleteMessage(int id) {
        messageRepository.deleteMessage(id);
    }
}
