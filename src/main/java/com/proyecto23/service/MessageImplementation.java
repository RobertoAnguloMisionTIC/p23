package com.proyecto23.service;

import com.proyecto23.model.Message;
import com.proyecto23.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MessageImplementation implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public void create(Message message) {
        if(message.getIdMessage() != null){
            if(messageRepository.existsById(message.getIdMessage())){
                return;
            }else{
                messageRepository.save(message);
                return;
            }
        }else {
            messageRepository.save(message);
            return;
        }
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
