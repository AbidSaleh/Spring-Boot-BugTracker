package com.hillel.bugtracker.model.converter;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.requestModel.MessageRequest;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MessageConverter {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Transactional
    public Message getConvertedMessage(MessageRequest messageRequest) {
        Message message = new Message();

        message.setTicket(ticketService.getTicket(messageRequest.getTicketId()));
        message.setAuthor(userService.getUser(messageRequest.getAuthorId()));
        message.setRecipient(userService.getUser(messageRequest.getRecipientId()));
        message.setText(messageRequest.getText());

        return message;
    }

}
