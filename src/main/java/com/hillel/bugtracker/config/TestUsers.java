package com.hillel.bugtracker.config;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.repository.MessageRepository;
import com.hillel.bugtracker.repository.TicketRepository;
import com.hillel.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUsers implements InitializingBean {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        User bigBoss = new User("Big", "Boss", "BigBoss@email.com");
        User usualEmployee = new User("Usual", "Employee", "employee@email.com");

        userRepository.save(bigBoss);
        userRepository.save(usualEmployee);

        Ticket ticket = new Ticket();
        ticket.setCreator(bigBoss);
        ticket.setHolder(usualEmployee);
        ticket.setTitle("Test");

        ticketRepository.save(ticket);

        Message message = new Message();
        message.setText("TEEEEEEEEEEEEEEST");
        message.setAuthor(bigBoss);
        message.setRecipient(usualEmployee);
        message.setTicket(ticket);

        messageRepository.saveMessage(message);

    }
}
