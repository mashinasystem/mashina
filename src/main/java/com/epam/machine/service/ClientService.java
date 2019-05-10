package com.epam.machine.service;

import com.epam.machine.entity.Client;

import java.sql.SQLException;

public interface ClientService {

    void create(Client client) throws SQLException, ClassNotFoundException;

    void delete(int id) throws SQLException, ClassNotFoundException;

    void update(Client client) throws SQLException, ClassNotFoundException;

    Client get(String login) throws SQLException, ClassNotFoundException;

    boolean clientLoginCheck(String login,String password) throws SQLException, ClassNotFoundException;
}
