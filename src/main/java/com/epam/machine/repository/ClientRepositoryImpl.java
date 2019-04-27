package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.sql.*;

@Data
public class ClientRepositoryImpl implements ClientRepository{
    final static String dataBaseUrl = "jdbc:postgresql://localhost:5432/Car";
    final static String jdbcDriver = "org.postgresql.Driver";

    final static String admin = "Admin";
    final static String password = "qwerty";

    @Builder
    @Override
    public Client get(int id) throws ClassNotFoundException,SQLException {
        Class.forName(jdbcDriver);

        String fullName = "";
        String passport = "";
        String driverCard = "";
        String phoneNumber = "";
        String eMail = "";
        String login = "";
        String pasword = "";

        ResultSet resultSet;
        try(Connection connection = DriverManager.getConnection(dataBaseUrl,admin,password);
        Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                fullName = resultSet.getString(2);
                passport = resultSet.getString(3);
                driverCard = resultSet.getString(4);
                phoneNumber = resultSet.getString(5);
                eMail = resultSet.getString(1);
                login = resultSet.getString(6);
                pasword = resultSet.getString(7);
            }
        }
        Client client = null;
        client = client.builder()
                .id(id)
                .fullName(fullName)
                .passport(passport)
                .driverCard(driverCard)
                .phoneNumber(phoneNumber)
                .eMail(eMail)
                .login(login)
                .password(password)
                .build();

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
