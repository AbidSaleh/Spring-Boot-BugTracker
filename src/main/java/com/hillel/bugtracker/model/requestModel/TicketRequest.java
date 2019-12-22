package com.hillel.bugtracker.model.requestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TicketRequest {

    private int ticketId;

    private String title;

    private int creatorId;

    private int holderId;

}
