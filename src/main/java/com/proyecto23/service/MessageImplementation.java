package com.proyecto23.service;

import com.proyecto23.model.Client;
import com.proyecto23.model.Message;
import com.proyecto23.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class MessageImplementation implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public Message create(Message message) {
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> messageNew = getMessage(message.getIdMessage());
            if (messageNew.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }

    @Override
    public Optional<Message> getMessage(Integer id) {
        return messageRepository.findById(id);
    }

    @Override
    public List<Message> messages() {
        return (List<Message>) messageRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Message message) {
        if (messageRepository.existsById(message.getIdMessage())){
            messageRepository.save(message);
            return;
        }else
            return;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if(messageRepository.existsById(id)){
            messageRepository.deleteById(id);
            return;
        }else
            return;
    }
}
