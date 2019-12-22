package com.hillel.bugtracker.model.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequest {

    private int messageId;

    private int ticketId;

    private int authorId;

    private int recipientId;

    private String text;

}
