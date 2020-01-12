package com.hillel.bugtracker.model.converter;

import com.hillel.bugtracker.model.TicketEntity;
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

    public TicketEntity getConvertedTicket(TicketRequest ticketRequest) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTitle(ticketRequest.getTitle());
        ticketEntity.setCreator(userService.getUser(ticketRequest.getCreatorId()));
        ticketEntity.setHolder(userService.getUser(ticketRequest.getHolderId()));
        ticketService.addTicket(ticketEntity);
        return ticketEntity;
    }
}
