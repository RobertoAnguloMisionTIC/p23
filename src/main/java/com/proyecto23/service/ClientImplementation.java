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
    @Transactional
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
