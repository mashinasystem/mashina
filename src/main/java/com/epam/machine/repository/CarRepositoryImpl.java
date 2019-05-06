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
             PreparedStatement statement = connection.prepareStatement(
                     "select * from car where car.id = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
        }
        return Car.builder()
                .id(id)
                .marque(resultSet.getString(1))
                .model(resultSet.getString(2))
                .number(resultSet.getString(3))
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
