package com.proyecto23.service;

import com.proyecto23.model.Client;
import com.proyecto23.model.Message;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    public Message create(Message message);
    public Optional<Message> getMessage(Integer id);
    public List<Message> messages();
    public Message update(Message message);
    public boolean delete(Integer id);
}
