package com.hillel.bugtracker.model.converter;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.requestModel.MessageRequest;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageToRequestConverter {
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    public Message getConvertedMessage(Message message) {
        MessageRequest messageRequest = new MessageRequest();
        messageRequest.setMessageId(message.getMessageId());


        message.setTicketId(messageRequest.getTicketId());
        message.setAuthor(userService.getUser(messageRequest.getAuthorId()));
        message.setRecipient(userService.getUser(messageRequest.getRecipientId()));
        message.setText(messageRequest.getText());
        ticketService.addMessage(message);
        return message;
    }
}
