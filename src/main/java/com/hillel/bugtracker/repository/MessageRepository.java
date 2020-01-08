package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.Message;

public interface MessageRepository {

    public void saveMessage(Message message);

    public void updateMessage(Message message);

    public void deleteMessage(int id);

}
