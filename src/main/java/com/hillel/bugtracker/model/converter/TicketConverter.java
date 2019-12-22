package com.hillel.bugtracker.model.converter;

import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.model.requestModel.TicketRequest;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketConverter {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    public Ticket getConvertedTicket(TicketRequest ticketRequest) {
        Ticket ticket = new Ticket();
        ticket.setTitle(ticketRequest.getTitle());
        ticket.setCreator(userService.getUser(ticketRequest.getCreatorId()));
        ticket.setHolder(userService.getUser(ticketRequest.getHolderId()));
        ticketService.addTicket(ticket);
        return ticket;
    }
}
