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

    public MessageRequest getConvertedMessage(Message message) {
        MessageRequest messageRequest = new MessageRequest();

        messageRequest.setMessageId(message.getMessageId());
        messageRequest.setTicketId(message.getTicket().getTicketId());
        messageRequest.setAuthorId(message.getAuthor().getUserId());
        messageRequest.setRecipientId(message.getRecipient().getUserId());
        messageRequest.setText(message.getText());
        return messageRequest;
    }
}
