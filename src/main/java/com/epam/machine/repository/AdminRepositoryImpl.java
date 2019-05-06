package com.epam.machine.repository;

import com.epam.machine.entity.Admin;

import java.sql.*;

public class AdminRepositoryImpl implements AdminRepository {

    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Override
    public Admin get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM administrator WHERE administrator.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            resultSet.next();

            return Admin.builder()
                    .name(resultSet.getString(2))
                    .login(resultSet.getString(3))
                    .password(resultSet.getString(4))
                    .build();
        }
    }

    @Override
    public void create(Admin admin) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO administrator (name,login,password) VALUES (\'" + admin.getName() +
                    "\',\'" + admin.getLogin() + "\',\'" + admin.getPassword() + "\');";
            statement.executeUpdate(sql);
        }

    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "DELETE FROM administrator WHERE administrator.id = " + id + ";";
            statement.executeUpdate(sql);

        }
    }

    @Override
    public void update(int id, Admin admin) throws ClassNotFoundException, SQLException {

        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE administrator SET name = " + admin.getName() + ", login = "
                    + admin.getLogin() + ", password = " + admin.getPassword() + " WHERE administrator.id = "
                    + id + " ;";

            statement.executeUpdate(sql);
        }

    }

    @Override
    public int getByLogin(String login) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet = null;
        int id = 0;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM administrator WHERE login = \'" + login + "\';";
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        }

        return id;
    }

}
