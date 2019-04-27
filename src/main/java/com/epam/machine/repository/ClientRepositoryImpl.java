package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Data;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

@Data
public class ClientRepositoryImpl implements ClientRepository{
    final static String dataBaseUrl = "jdbc:postgresql://localhost:5432/Car";
    final static String jdbcDriver = "org.postgresql.Driver";

    final static String admin = "Admin";
    final static String password = "qwerty";

    @Override
    public Client get(int id) throws ClassNotFoundException,SQLException {
        Class.forName(jdbcDriver);

        Client client = null;
        ResultSet resultSet;
        try(Connection connection = DriverManager.getConnection(dataBaseUrl,admin,password);
        Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                client.of(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                        resultSet.getString(5), resultSet.getString(1), resultSet.getString(6),
                        resultSet.getString(7));
            }

        }

        return client;
    }

    @Override
    public void create(Client client) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Client client) {

    }

    @Override
    public int getIdByLogin(String login) throws ClassNotFoundException,SQLException  {
        Class.forName(jdbcDriver);
        ResultSet resultSet = null;
        int id=0;
        try(Connection connection = DriverManager.getConnection(dataBaseUrl,admin,password);
            Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM driver WHERE driver.login = \'" + login + "\';";
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }

        return id;
    }
}
