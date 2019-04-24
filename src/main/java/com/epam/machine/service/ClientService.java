package com.epam.machine.service;

import com.epam.machine.entity.Client;

public interface ClientService {

    void create(String input);
    void delete(int id);
    void update(int id,String input);
    Client getData(int id);
}
