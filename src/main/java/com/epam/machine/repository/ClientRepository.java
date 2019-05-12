package com.epam.machine.repository;

import com.epam.machine.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository {
    Client get(int id) throws ClassNotFoundException, SQLException;

    void create(Client client) throws ClassNotFoundException, SQLException;

    void delete(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Client client) throws ClassNotFoundException, SQLException;

    int getIdByLogin(String login) throws ClassNotFoundException, SQLException;

    boolean checkLogin(String login,String password) throws ClassNotFoundException, SQLException;

    List<Client> getAll() throws ClassNotFoundException, SQLException;
}
