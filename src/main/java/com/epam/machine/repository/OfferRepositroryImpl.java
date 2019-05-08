package com.epam.machine.repository;

import com.epam.machine.entity.Offer;
import com.epam.machine.service.CarServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OfferRepositroryImpl implements OfferRepository {
    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Override
    public List<Offer> get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        List<Offer> offers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where offer.driver_id = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                CarServiceImpl carService = new CarServiceImpl();
                offers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(id)
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .build());
            }
        }
        return offers;
    }

    @Override
    public void create(Offer offer) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO offer " + "(driver_id,admin_id,car_id,payment,period_days,status)" +
                    " VALUES (" + "\'" + offer.getDriverId() + "\',\'" + 1 + "\',\'" +
                    3 + "\',\'" + offer.getPayment() + "\',\'" + offer.getPeriod() +
                    "\',\'" + offer.getStatus() + "\');";
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void delete(int id) {}

    @Override
    public void update(int id) {}
}
