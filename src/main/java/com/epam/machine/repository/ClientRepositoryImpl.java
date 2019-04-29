package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Builder;
import lombok.Data;

import java.sql.*;

@Data
public class ClientRepositoryImpl implements ClientRepository {
    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Builder
    @Override
    public Client get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        String fullName = "";
        String passport = "";
        String driverCard = "";
        String phoneNumber = "";
        String eMail = "";
        String login = "";
        String pasword = "";

        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
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

        return Client.builder()
                .id(id)
                .fullName(fullName)
                .passport(passport)
                .driverCard(driverCard)
                .phoneNumber(phoneNumber)
                .eMail(eMail)
                .login(login)
                .password(pasword)
                .build();
    }

    @Override
    public void create(Client client) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO driver " + "(name,passport,licence,phone_num,login,password)" +
                    " VALUES (" + "\'" + client.getFullName() + "\',\'" + client.getPassport() + "\',\'" +
                    client.getDriverCard() + "\',\'" + client.getPhoneNumber() + "\',\'" + client.getLogin() +
                    "\',\'" + client.getPassword() + "\');";
            statement.executeUpdate(sql);
        }


    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM driver WHERE driver.id = " + id + ";";
            statement.executeUpdate(sql);

        }

    }

    @Override
    public void update(int id, Client client) {

    }

    @Override
    public int getIdByLogin(String login) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet = null;
        int id = 0;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.login = \'" + login + "\';";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }

        return id;
    }
}