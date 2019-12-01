package com.hillel.bugtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {

    private int ticketId;
    private String name;
    private List<Message> messages;
    private int creatorId;
    private int holderId;

}
