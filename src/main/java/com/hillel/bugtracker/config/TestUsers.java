package com.hillel.bugtracker.config;

import com.hillel.bugtracker.model.MessageEntity;
import com.hillel.bugtracker.model.TicketEntity;
import com.hillel.bugtracker.model.UserEntity;
import com.hillel.bugtracker.repository.MessageRepository;
import com.hillel.bugtracker.repository.RoleRepository;
import com.hillel.bugtracker.repository.TicketRepository;
import com.hillel.bugtracker.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;

@Component
public class TestUsers implements InitializingBean {

    @Autowired
    private UserService userService;


    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void afterPropertiesSet() throws Exception {

        roleRepository.createRoleIfNotFound("ROLE_ADMIN");
        roleRepository.createRoleIfNotFound("ROLE_USER");
        roleRepository.createRoleIfNotFound("ROLE_BOSS");


        UserEntity admin = new UserEntity("Alex", "Zhuravlov", "alexzhuravlov13@gmail.com", "111111");

        UserEntity bigBoss = new UserEntity("Big", "Boss", "BigBoss@email.com", "111111");


        UserEntity usualEmployee = new UserEntity("Usual", "Employee", "employee@email.com", "111111");

        userService.addUser(bigBoss);
        bigBoss.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"), roleRepository.findByName("ROLE_BOSS"))));

        userService.addUser(admin);
        admin.setRoles(new HashSet<>(Arrays.asList(roleRepository.findByName("ROLE_USER"), roleRepository.findByName("ROLE_ADMIN"))));

        userService.updateUser(bigBoss);
        userService.updateUser(admin);

        userService.addUser(usualEmployee);

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setCreator(bigBoss);
        ticketEntity.setHolder(usualEmployee);
        ticketEntity.setTitle("Test");

        ticketRepository.save(ticketEntity);

        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setText("TEEEEEEEEEEEEEEST");
        messageEntity.setAuthor(bigBoss);
        messageEntity.setRecipient(usualEmployee);
        messageEntity.setTicket(ticketEntity);

        messageRepository.save(messageEntity);

    }
}
