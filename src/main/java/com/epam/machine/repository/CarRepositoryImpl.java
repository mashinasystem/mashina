package com.epam.machine.repository;

import com.epam.machine.entity.Car;
import com.epam.machine.service.CarService;
import com.epam.machine.service.CarServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    private CarService carService = new CarServiceImpl();

    @Override
    public Car get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from car where car.id = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            return Car.builder()
                    .id(id)
                    .marque(resultSet.getString(2))
                    .model(resultSet.getString(3))
                    .number(resultSet.getString(4))
                    .build();
        }
    }

    @Override
    public void create(Car car) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO car " + "(marque,model,number)" +
                    " VALUES (" + "\'" + car.getMarque() + "\',\'" + car.getModel() + "\',\'" +
                    car.getNumber() + "\');";
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<Car> getAll() throws ClassNotFoundException, SQLException {
        List<Car> cars = new ArrayList<>();
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from car")) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                cars.add(carService.get(resultSet.getInt(1)));
            }
            return cars;
        }
    }
}
