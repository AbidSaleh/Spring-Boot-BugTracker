package com.hillel.bugtracker.config;

import com.hillel.bugtracker.model.Message;
import com.hillel.bugtracker.model.User;
import com.hillel.bugtracker.repository.MessageRepository;
import com.hillel.bugtracker.repository.UserRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestUsers implements InitializingBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        userRepository.save(new User("Big", "Boss", "BigBoss@email.com"));
        userRepository.save(new User("Usual", "Employee", "employee@email.com"));

        Message message = new Message();
        message.setText("TEEEEEEEEEEEEEEST");
        messageRepository.saveMessage(message);

    }
}
