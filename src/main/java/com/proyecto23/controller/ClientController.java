package com.proyecto23.controller;

import com.proyecto23.model.Box;
import com.proyecto23.model.Client;
import com.proyecto23.service.BoxImplementation;
import com.proyecto23.service.ClientImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Client")
@CrossOrigin(origins = "*")
public class ClientController {
    @Autowired
    private ClientImplementation clientImplementation;

    @PostMapping("/save")
    public void createClient(@RequestBody Client client){
        clientImplementation.create(client);
    }

    @GetMapping("/all")
    public List<Client> getClients(){
        return clientImplementation.clients();
    }

    @PutMapping("/update")
    public void updateClient(@RequestBody Client client){
        clientImplementation.update(client);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteClient(@PathVariable ("id") Integer id){
        clientImplementation.delete(id);
    }
}
