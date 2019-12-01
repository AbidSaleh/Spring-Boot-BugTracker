package com.hillel.bugtracker;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;

public class TestData {
    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    public void fill (){

        userService.addUser(new User(1, "Alex", "Zhuravlov", "alexzuravlov13@gmail.com", new ArrayList<>()));
        userService.addUser(new User(2, "Vyacheslav", "Serdyn", "Serdyn@gmail.com", new ArrayList<>()));

        ticketService.addTicket(new Ticket(
                1,
                "Create first ticket",
                new ArrayList<Message>(Arrays.asList(
                        new Message(1, userService.getUser(1), userService.getUser(2), "Get the first message"),
                        new Message(2, userService.getUser(2), userService.getUser(1), "Answer at your message"))),
                userService.getUser(1), userService.getUser(2)));

    }
}
