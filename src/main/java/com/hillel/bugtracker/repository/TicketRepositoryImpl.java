package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Ticket;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TicketRepositoryImpl implements TicketRepository {

    private int currentTicketId;
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
}
