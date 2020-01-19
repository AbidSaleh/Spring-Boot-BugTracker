package com.hillel.bugtracker.controller;

import com.hillel.bugtracker.model.TicketEntity;
import com.hillel.bugtracker.model.UserEntity;
import com.hillel.bugtracker.model.converter.MessageConverter;
import com.hillel.bugtracker.model.converter.TicketConverter;
import com.hillel.bugtracker.model.requestModel.TicketRequest;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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
    public ModelAndView getTicketsList(@RequestParam("userId") String userId) {
        if (userId == "") {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            int userNameId = userService.findByUsername(userName).getUserId();
            userId = String.valueOf(userNameId);
        }
        int id = Integer.parseInt(userId);

        List<TicketEntity> userTickets = ticketService.findUsersTickets(id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tickets", userTickets);
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

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        int userId = userService.findByUsername(userName).getUserId();

        TicketEntity ticketEntity = ticketService.getTicket(Integer.parseInt(ticketId));

        ModelAndView modelAndView = new ModelAndView();

        if (ticketEntity.getCreator().getUserId() == userId
                || ticketEntity.getHolder().getUserId() == userId
                || authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {

            modelAndView.addObject("ticket", ticketEntity);
            modelAndView.setViewName("ticketView");

        } else {
            modelAndView.setStatus(HttpStatus.FORBIDDEN);
        }
        return modelAndView;

    }


}
