package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Data;

import javax.print.DocFlavor;
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
        Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM driver WHERE driver.id = " + id;
            resultSet = statement.executeQuery(sql);
        }

        return client.of(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3),
                resultSet.getNString(4),resultSet.getNString(5),resultSet.getString(6),
                resultSet.getString(7));
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
        ResultSet resultSet;
        try(Connection connection = DriverManager.getConnection(dataBaseUrl,admin,password);
            Statement statement = connection.createStatement())
        {
            String sql = "SELECT * FROM driver WHERE driver.login = \'" + login + "\'";
            resultSet = statement.executeQuery(sql);
        }

        resultSet.next();

        return resultSet.getInt(1);
    }
}
