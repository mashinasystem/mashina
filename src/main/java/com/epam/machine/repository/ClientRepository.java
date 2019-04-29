package com.epam.machine.repository;

import com.epam.machine.entity.Client;

import java.sql.SQLException;

public interface ClientRepository {
    Client get(int id) throws ClassNotFoundException, SQLException;

    void create(Client client) throws ClassNotFoundException, SQLException;

    void delete(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Client client);

    int getIdByLogin(String login) throws ClassNotFoundException, SQLException;
}
