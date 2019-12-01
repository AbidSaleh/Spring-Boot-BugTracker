package com.hillel.bugtracker.controller;

import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getTicketsList(){
        List<Ticket> ticketList = ticketService.getTickets();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", ticketList);
        modelAndView.setViewName("ticketsList");
        return modelAndView;
    }

}
