package com.proyecto23.controller;

import com.proyecto23.model.Message;
import com.proyecto23.service.MessageImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Message")
@CrossOrigin(origins = "*")
public class MessageController {
    @Autowired
    private MessageImplementation messageImplementation;

    @PostMapping("/save")
    public void createMessage(@RequestBody Message message){
        messageImplementation.create(message);
    }

    @GetMapping("/all")
    public List<Message> getMessages(){
        return messageImplementation.messages();
    }

    @PutMapping("/update")
    public void updateMessage(@RequestBody Message message){
        messageImplementation.update(message);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteMessage(@PathVariable ("id") Integer id){
        messageImplementation.delete(id);
    }
}
