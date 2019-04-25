package com.epam.machine.service;

import com.epam.machine.entity.Client;

public interface ClientService {

    void create(Client client);
    void delete(int id);
    void update(Client client);
    Client get(String login);
}
