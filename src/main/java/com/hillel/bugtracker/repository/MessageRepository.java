package com.hillel.bugtracker.repository;

import com.hillel.bugtracker.model.MessageEntity;

public interface MessageRepository {

    public void saveMessage(MessageEntity messageEntity);

    public void updateMessage(MessageEntity messageEntity);

    public void deleteMessage(int id);

}
