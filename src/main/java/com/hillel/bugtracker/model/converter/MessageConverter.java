package com.hillel.bugtracker.model.converter;

import com.hillel.bugtracker.model.MessageEntity;
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
    public MessageEntity getConvertedMessage(MessageRequest messageRequest) {
        MessageEntity messageEntity = new MessageEntity();

        messageEntity.setCreateDate(messageRequest.getCreateDate());
        messageEntity.setTicket(ticketService.getTicket(messageRequest.getTicketId()));
        messageEntity.setAuthor(userService.getUser(messageRequest.getAuthorId()));
        messageEntity.setRecipient(userService.getUser(messageRequest.getRecipientId()));
        messageEntity.setText(messageRequest.getText());

        return messageEntity;
    }

}
