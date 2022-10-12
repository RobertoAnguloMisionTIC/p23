package com.proyecto23.service;

import com.proyecto23.model.Client;

import java.util.List;

public interface ClientService {
    public void create(Client client);
    public List<Client> clients();
    public void update(Client client);
    public void delete(Integer id);
}
