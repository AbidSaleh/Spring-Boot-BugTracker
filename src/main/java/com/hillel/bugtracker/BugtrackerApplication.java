package com.hillel.bugtracker;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.Ticket;
import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.service.TicketService;
import com.hillel.bugtracker.service.TicketServiceImpl;
import com.hillel.bugtracker.service.UserService;
import com.hillel.bugtracker.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BugtrackerApplication {



    public static void main(String[] args) {
        SpringApplication.run(BugtrackerApplication.class, args);
        TestData testData = new TestData();
        testData.fill();
    }

}
