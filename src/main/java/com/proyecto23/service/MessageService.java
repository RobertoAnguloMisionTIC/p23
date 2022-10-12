package com.proyecto23.service;

import com.proyecto23.model.Client;
import com.proyecto23.model.Message;

import java.util.List;

public interface MessageService {
    public void create(Message message);
    public List<Message> messages();
    public void update(Message message);
    public void delete(Integer id);
}
