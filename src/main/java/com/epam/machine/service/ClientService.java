package com.epam.machine.service;

import com.epam.machine.entity.Client;

import java.sql.SQLException;

public interface ClientService {

    void create(Client client);
    void delete(int id);
    void update(Client client) throws SQLException, ClassNotFoundException;
    Client get(String login) throws SQLException, ClassNotFoundException;
}
