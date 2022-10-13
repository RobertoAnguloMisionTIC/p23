package com.proyecto23.service;

import com.proyecto23.model.Message;
import com.proyecto23.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageImplementation implements MessageService{
    @Autowired
    private MessageRepository messageRepository;

    @Override
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
    public Message update(Message message) {
        if (message != null && message.getIdMessage() != null){
            if (messageRepository.existsById(message.getIdMessage())){
                Optional<Message> oldMessage = messageRepository.findById(message.getIdMessage());
                Message editedMessage = oldMessage.get();
                if (message.getMessageText() != null){
                    editedMessage.setMessageText(message.getMessageText());
                }
                if (message.getBox() != null){
                    editedMessage.setBox(message.getBox());
                }
                if (message.getClient() != null){
                    editedMessage.setClient(message.getClient());
                }
                return messageRepository.save(editedMessage);
            }else{
                return message;
            }
        }else {
            return message;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(messageRepository.existsById(id)){
            messageRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
