package com.proyecto23.service;

import com.proyecto23.model.Category;
import com.proyecto23.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientService {
    public Client create(Client client);
    public Optional<Client> getClient(Integer id);
    public List<Client> clients();
    public Client update(Client client);
    public boolean delete(Integer id);
}
