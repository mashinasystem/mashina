package com.epam.machine.repository;

import com.epam.machine.entity.Client;

public interface ClientRepository
{
    Client get(int id);
    void create(Client client);
    void delete(int id);
    void update(int id,Client client);
    int getIdByLogin(String login);


}
