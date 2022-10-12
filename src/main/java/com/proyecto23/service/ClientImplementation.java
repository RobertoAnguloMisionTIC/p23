package com.proyecto23.service;

import com.proyecto23.model.Client;
import com.proyecto23.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ClientImplementation implements ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Override
    @Transactional
    public void create(Client client) {
        if(client.getIdClient() != null){
            if(clientRepository.existsById(client.getIdClient())){
                return;
            }else{
                clientRepository.save(client);
                return;
            }
        }else {
            clientRepository.save(client);
            return;
        }
    }

    @Override
    public List<Client> clients() {
        return (List<Client>) clientRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Client client) {
        if (clientRepository.existsById(client.getIdClient())){
            clientRepository.save(client);
            return;
        }else
            return;
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return;
        }else
            return;
    }
}
