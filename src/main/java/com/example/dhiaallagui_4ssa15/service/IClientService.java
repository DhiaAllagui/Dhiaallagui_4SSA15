package com.example.dhiaallagui_4ssa15.service;

import com.example.dhiaallagui_4ssa15.entity.Client;

import java.util.List;

public interface IClientService {
    Client addClient(Client client);

    Client updateClient(Client client);

    Client retrieveClient(Long id);

    List<Client> retrieveAllClients();

    void removeClient(Long id);
}
