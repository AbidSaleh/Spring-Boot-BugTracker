package com.hillel.bugtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int messageId;
    private int ticketId;
    private int authorId;
    private int recipientId;
    private String text;
}
