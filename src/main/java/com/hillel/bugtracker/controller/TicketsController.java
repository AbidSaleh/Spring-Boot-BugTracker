package com.hillel.bugtracker.controller;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tickets")
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getTicketsList(@RequestParam("userId") int userId){

        List<Ticket> ticketList = ticketService.getTickets().stream().
                filter(ticket -> ticket.getCreatorId() == userId)
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", ticketList);
        modelAndView.setViewName("ticketsList");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addTicketForm(Model model, @RequestParam("userId") int userId){
        Ticket ticket = new Ticket();
        ticket.setCreatorId(userId);
        model.addAttribute("ticketAttribute", ticket);
        return "ticketAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTicket")
    public String addTicket(@ModelAttribute("ticketAttribute") @Validated Ticket ticket){
        ticketService.addTicket(ticket);
        return "redirect:/tickets/addMessageForm"+"?ticketId="+ticket.getTicketId()+"&authorId="+ticket.getCreatorId()+"&recipientId="+ticket.getHolderId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addMessageForm")
    public String addMessageForm(Model model, @RequestParam("authorId") int authorId, @RequestParam("recipientId") int recipientId  ){
        model.addAttribute("messageAttribute", new Message());
        return "messageAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMessage")
    public String addMessage(@ModelAttribute("messageAttribute") @Validated Message message){
        ticketService.addMessage(message.getTicketId(), message);
        return "redirect:/tickets/"+message.getTicketId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/tickets/{ticketId}")
    public ModelAndView showTicket(@PathVariable String ticketId){
        Ticket ticket = ticketService.getTicket(Integer.parseInt(ticketId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ticket", ticket);
        modelAndView.setViewName("ticketView");
        return modelAndView;
    }

}