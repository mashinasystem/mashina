package com.epam.machine.repository;

import com.epam.machine.entity.Car;
import lombok.Builder;

import java.sql.*;

public class CarRepositoryImpl implements CarRepository {

    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Builder
    @Override
    public Car get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        int carId = id;
        String number = "";
        String marque = "";
        String model = "";
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM car WHERE car.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                number = resultSet.getString(3);
                marque = resultSet.getString(1);
                model = resultSet.getString(2);
            }
        }
        return Car.builder()
                .id(id)
                .marque(marque)
                .model(model)
                .number(number)
                .build();
    }

    @Override
    public void create(Car car) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}
