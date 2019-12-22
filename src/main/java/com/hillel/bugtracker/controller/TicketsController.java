package com.hillel.bugtracker.controller;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.model.converter.MessageConverter;
import com.hillel.bugtracker.model.converter.TicketConverter;
import com.hillel.bugtracker.model.requestModel.MessageRequest;
import com.hillel.bugtracker.model.requestModel.TicketRequest;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/tickets")
@Slf4j
public class TicketsController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketConverter ticketConverter;

    @Autowired
    private MessageConverter messageConverter;

    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ModelAndView getTicketsList(@RequestParam("userId") int userId) {

        List<Ticket> ticketList = ticketService.getTickets().stream().
                filter(ticket -> ticket.getCreator().getUserId() == userId)
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", ticketList);
        modelAndView.setViewName("ticketsList");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addTicketForm(Model model, @RequestParam("userId") int userId) {
        TicketRequest ticketRequest = new TicketRequest();
        ticketRequest.setCreatorId(userId);
        model.addAttribute("ticketAttribute", ticketRequest);
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "ticketAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTicket")
    public String addTicket(@ModelAttribute("ticketAttribute") TicketRequest ticketRequest) {
        Ticket ticket = ticketConverter.getConvertedTicket(ticketRequest);
        return "redirect:/tickets/addMessageForm" + "?ticketId=" + ticket.getTicketId() + "&authorId=" + ticket.getCreator().getUserId() + "&recipientId=" + ticket.getHolder().getUserId();
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public ModelAndView showTicket(@PathVariable String ticketId) {
        Ticket ticket = ticketService.getTicket(Integer.parseInt(ticketId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ticket", ticket);
        modelAndView.setViewName("ticketView");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addMessageForm")
    public String addMessageForm(Model model, @RequestParam("authorId") int authorId) {
        model.addAttribute("messageAttribute", new MessageRequest());
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "messageAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMessage")
    public String addMessage(@ModelAttribute("messageAttribute") MessageRequest messageRequest) {
        Message message = messageConverter.getConvertedMessage(messageRequest);
        ticketService.addMessage(message);
        ticketService.getTicket(message.getTicketId()).setHolder(message.getRecipient());
        return "redirect:/tickets/" + message.getTicketId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editMessageForm")
    public String editMessageForm(Model model, @RequestParam("ticketId") int ticketId, @RequestParam("messageId") int messageId) {
        Message message = ticketService.getTicket(ticketId).getMessages().get(messageId);
        MessageRequest messageRequest = new MessageRequest(message.getMessageId(), message.getTicketId(),
                message.getAuthor().getUserId(), message.getRecipient().getUserId(), message.getText());
        model.addAttribute("messageAttribute", messageRequest);
        return "messageEdit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editMessage")
    public String editMessage(@ModelAttribute("messageAttribute") @Validated MessageRequest messageRequest) {
        Message message = messageConverter.getConvertedMessage(messageRequest);
        message.setMessageId(messageRequest.getMessageId());
        ticketService.addMessage(message);
        return "redirect:/tickets/" + message.getTicketId();
    }


}
