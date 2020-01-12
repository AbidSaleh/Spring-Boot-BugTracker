package com.hillel.bugtracker.controller;

import com.hillel.bugtracker.model.MessageEntity;
import com.hillel.bugtracker.model.TicketEntity;
import com.hillel.bugtracker.model.UserEntity;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
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
    public ModelAndView getTicketsList(@RequestParam("userId") String userId,
                                       HttpServletRequest request) {
        if (userId == "") {
            String username = request.getUserPrincipal().getName();
            int usernameId = userService.findByUsername(username).getUserId();
            userId = String.valueOf(usernameId);
        }
        int id = Integer.parseInt(userId);


        List<TicketEntity> ticketEntityList = ticketService.getTickets().stream().
                filter(ticket -> ticket.getCreator().getUserId() == id)
                .collect(Collectors.toList());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", ticketEntityList);
        modelAndView.addObject("loggedInId", userId);
        modelAndView.setViewName("ticketsList");
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String addTicketForm(Model model, @RequestParam("userId") int userId) {
        TicketRequest ticketRequest = new TicketRequest();
        ticketRequest.setCreatorId(userId);
        model.addAttribute("ticketAttribute", ticketRequest);
        List<UserEntity> userEntities = userService.getUsers();
        model.addAttribute("users", userEntities);
        return "ticketAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addTicket")
    public String addTicket(Model model, @ModelAttribute("ticketAttribute")
    @Validated TicketRequest ticketRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<UserEntity> userEntities = userService.getUsers();
            model.addAttribute("users", userEntities);
            return "ticketAdd";
        } else {
            TicketEntity ticketEntity = ticketConverter.getConvertedTicket(ticketRequest);
            return "redirect:/tickets/addMessageForm" + "?ticketId=" + ticketEntity.getTicketId() + "&authorId=" + ticketEntity.getCreator().getUserId() + "&recipientId=" + ticketEntity.getHolder().getUserId();
        }
    }


    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public ModelAndView showTicket(@PathVariable String ticketId) {
        TicketEntity ticketEntity = ticketService.getTicket(Integer.parseInt(ticketId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ticket", ticketEntity);
        modelAndView.setViewName("ticketView");
        ticketEntity.getCreateDate().toLocalDate();
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/addMessageForm")
    public String addMessageForm(Model model) {
        model.addAttribute("messageAttribute", new MessageRequest());
        List<UserEntity> userEntities = userService.getUsers();
        model.addAttribute("users", userEntities);
        return "messageAdd";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addMessage")
    public String addMessage(@ModelAttribute("messageAttribute") @Validated MessageRequest messageRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "messageAdd";
        } else {
            MessageEntity messageEntity = messageConverter.getConvertedMessage(messageRequest);

            TicketEntity ticketEntity = ticketService.getTicket(messageEntity.getTicket().getTicketId());
            ticketEntity.setHolder(messageEntity.getRecipient());

            ticketService.addMessage(messageEntity);
            return "redirect:/tickets/" + messageEntity.getTicket().getTicketId();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/editMessageForm")
    public String editMessageForm(Model model, @RequestParam("ticketId") int ticketId, @RequestParam("messageId") int messageId) {
        MessageEntity messageEntity = null;
        for (MessageEntity messageEntity1 : ticketService.getTicket(ticketId).getMessages()) {
            if (messageEntity1.getMessageId() == messageId) {
                messageEntity = messageEntity1;
            }
        }

        MessageRequest messageRequest = new MessageRequest(messageEntity.getMessageId(), messageEntity.getTicket().getTicketId(),
                messageEntity.getAuthor().getUserId(), messageEntity.getRecipient().getUserId(), messageEntity.getCreateDate(), messageEntity.getText());
        model.addAttribute("messageAttribute", messageRequest);
        return "messageEdit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/editMessage")
    public String editMessage(@ModelAttribute("messageAttribute") @Validated MessageRequest messageRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "redirect:/tickets/editMessageForm?ticketId=" + messageRequest.getTicketId() + "&messageId=" + messageRequest.getMessageId();
        } else {
            MessageEntity messageEntity = messageConverter.getConvertedMessage(messageRequest);
            messageEntity.setMessageId(messageRequest.getMessageId());
            ticketService.addMessage(messageEntity);
            return "redirect:/tickets/" + messageEntity.getTicket().getTicketId();
        }
    }


}
