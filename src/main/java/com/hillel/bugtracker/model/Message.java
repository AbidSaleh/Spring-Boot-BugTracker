package com.hillel.bugtracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private int messageId;
    private int ticketId;
    private int authorId;
    private int recipientId;
    private String text;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
