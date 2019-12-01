package com.hillel.bugtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {
    private int messageId;
    private int authorId;
    private int recipientId;
    private String text;
}
