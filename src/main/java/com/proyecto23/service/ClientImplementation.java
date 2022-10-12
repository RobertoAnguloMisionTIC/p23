package com.proyecto23.service;

import com.proyecto23.model.Category;
import com.proyecto23.model.Client;
import com.proyecto23.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClientImplementation implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client create(Client client) {
        if (client.getIdClient() == null){
            return clientRepository.save(client);
        }else{
            Optional<Client> clientNew = getClient(client.getIdClient());
            if (clientNew.isEmpty()){
                return clientRepository.save(client);
            }else {
                return client;
            }
        }
    }

    @Override
    public Optional<Client> getClient(Integer id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> clients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    public Client update(Client client) {
        if (client != null && client.getIdClient() != null){
            if (clientRepository.existsById(client.getIdClient())){
                Optional<Client> oldClient = clientRepository.findById(client.getIdClient());
                Client editedClient = oldClient.get();
                if (client.getEmail() != null){
                    editedClient.setName(client.getEmail());
                }
                if (client.getPassword() != null){
                    editedClient.setPassword(client.getPassword());
                }
                if (client.getName() != null){
                    editedClient.setName(client.getName());
                }
                if (client.getAge() != null){
                    editedClient.setAge(client.getAge());
                }
                if (client.getMessages() != null){
                    editedClient.setMessages(client.getMessages());
                }
                if (client.getReservations() != null){
                    editedClient.setReservations(client.getReservations());
                }
                return clientRepository.save(editedClient);
            }else{
                return client;
            }
        }else {
            return client;
        }
    }

    @Override
    public boolean delete(Integer id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }else
            return false;
    }
}
