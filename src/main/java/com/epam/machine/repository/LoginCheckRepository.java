package com.epam.machine.repository;

import java.sql.*;

public final class LoginCheckRepository {
    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";
    public static int checkLog(String username, String password) throws ClassNotFoundException, SQLException {
        if (username == null || password == null) {
            throw new IllegalArgumentException("No login or password");
        }
        String passwordDB = "";
        if (ConnectDBAdmin(username, password)) return 2;
        if (ConnectDBDriver(username, password)) return 1;
        return 0;
    }

    private LoginCheckRepository() {
    }

    private static boolean ConnectDBAdmin(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        String passwordDB = "";
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM administrator WHERE administrator.login = '" + username + "';";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                passwordDB = resultSet.getString(4);
            }
            if (!passwordDB.equals("")) {
                if (password.equals(passwordDB)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean ConnectDBDriver(String username, String password) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        String passwordDB = "";
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM driver WHERE driver.email = '" + username + "';";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                passwordDB = resultSet.getString(7);
            }
            if (!passwordDB.equals("")) {
                if (password.equals(passwordDB)) {
                    return true;
                }
            }
        }
        return false;
    }
}
