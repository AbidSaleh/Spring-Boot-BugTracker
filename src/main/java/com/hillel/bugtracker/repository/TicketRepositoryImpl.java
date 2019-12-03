package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private int currentTicketId=1;
    private int currentMessageId=1;
    private Map<Integer,Ticket> ticketMap = new ConcurrentHashMap();


    @Override
    public List<Ticket> getTicketList() {
        return new ArrayList<>(ticketMap.values());
    }

    @Override
    public Ticket getTicketById(int id) {
        return ticketMap.get(id);
    }

    @Override
    public void save(Ticket ticket) {
        if (ticketMap.get(ticket.getTicketId()) == null) {
            ticket.setTicketId(currentTicketId);
            currentTicketId++;
        }
        ticketMap.put(ticket.getTicketId(), ticket);
    }

    @Override
    public void update(Ticket ticket) {
        ticketMap.put(ticket.getTicketId(), ticket);
    }

    @Override
    public void delete(int id) {
        ticketMap.remove(id);
    }

    @Override
    public void saveMessage(Ticket ticket, Message message) {
        if (ticketMap.get(ticket.getTicketId()).getMessages().get(message.getMessageId()) == null) {
            message.setMessageId(currentMessageId);
            currentMessageId++;
        }

        ticket.getMessages().put(message.getMessageId(), message);
        ticketMap.put(ticket.getTicketId(), ticket);
    }
}
