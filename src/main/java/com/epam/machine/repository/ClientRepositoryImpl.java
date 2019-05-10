package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@NoArgsConstructor
public class ClientRepositoryImpl implements ClientRepository {
    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Override
    public Client get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            resultSet.next();

            return Client.builder()
                    .id(id)
                    .fullName(resultSet.getString(2))
                    .passport(resultSet.getString(3))
                    .driverCard(resultSet.getString(4))
                    .phoneNumber(resultSet.getString(5))
                    .eMail(resultSet.getString(6))
                    .password(resultSet.getString(7))
                    .build();
        }
    }

    @Override
    public void create(Client client) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO driver " + "(name,passport,license,phone_num,email,password)" +
                    " VALUES (?,?,?,?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, client.getFullName());
            preparedStatement.setString(2, client.getPassport());
            preparedStatement.setString(3, client.getDriverCard());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setString(5, client.getEMail());
            preparedStatement.setString(6, client.getPassword());
            preparedStatement.executeUpdate();

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
    public void update(int id, Client client) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE driver SET name = " + client.getFullName() + ", passport = " +
                    client.getPassword() + ", license = " + client.getDriverCard() + ", phone_num = "
                    + client.getPhoneNumber() + ", email = " + client.getEMail() + ", password = " +
                    client.getPassword() + " WHERE driver.id = " + id + ";";
            statement.executeUpdate(sql);
        }

    }

    @Override
    public int getIdByLogin(String login) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet = null;
        int id = 0;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.email = \'" + login + "\';";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }

        return id;
    }

    @Override
    public boolean checkLogin(String login, String password) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet = null;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE email = \'" + login + "\' AND password = \'" + password + "\';";
            resultSet = statement.executeQuery(sql);
            return resultSet.next();
        }
    }
}
