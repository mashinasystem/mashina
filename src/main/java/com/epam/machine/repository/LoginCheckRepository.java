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
        if (ConnectDB(username, password, "administrator.login", "administrator")) return 2;
        if (ConnectDB(username, password, "driver.email", "driver")) return 1;
        return 0;
    }

    private LoginCheckRepository() {
    }

    private static boolean ConnectDB(String username, String password, String field, String table)
            throws SQLException, ClassNotFoundException {
        int num;
        if (table.equals("driver")) {
            num = 7;
        } else {
            num = 4;
        }
        Class.forName(JDBC_DRIVER);
        String passwordDB = "";
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM " + table + " WHERE " + field + " = '" + username + "';";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                passwordDB = resultSet.getString(num);
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
