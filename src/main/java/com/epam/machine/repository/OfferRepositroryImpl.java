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
                        .id(resultSet.getInt(1))
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
                    offer.getCar().getId() + "\',\'" + offer.getPayment() + "\',\'" + offer.getPeriod() +
                    "\',\'" + offer.getStatus() + "\');";
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void delete(int id) {}

    @Override
    public void update(int id, String status) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE offer SET status = '" + status + "' WHERE offer.id = " + id + ";";
            statement.executeUpdate(sql);
        }
    }

    @Override
    public List<Offer> getAll() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);
        CarServiceImpl carService = new CarServiceImpl();
        List<Offer> offers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer")) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                offers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(resultSet.getInt(2))
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .id(resultSet.getInt(1))
                        .build());
            }
        }
        return offers;
    }

    public List<Offer> getPast(int id) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        List<Offer> pastOffers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where offer.driver_id = ? and (offer.status = ? or offer.status = ?)")) {
            statement.setInt(1, id);
            statement.setString(2, "Declined");
            statement.setString(3, "Finished");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                CarServiceImpl carService = new CarServiceImpl();
                pastOffers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(id)
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .id(resultSet.getInt(1))
                        .build());
            }
        }
        return pastOffers;
    }

    public List<Offer> getPresent(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        List<Offer> presentOffers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where offer.driver_id = ? and (offer.status = ? or offer.status = ?)")) {
            statement.setInt(1, id);
            statement.setString(2, "Not paid");
            statement.setString(3, "In progress");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                CarServiceImpl carService = new CarServiceImpl();
                presentOffers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(id)
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .id(resultSet.getInt(1))
                        .build());
            }
        }
        return presentOffers;
    }

    @Override
    public Offer getOffer(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where offer.id = ?")) {
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            resultSet.next();
            carId = resultSet.getInt(4);
            CarServiceImpl carService = new CarServiceImpl();
            Offer offer =  Offer.builder()
                    .car(carService.get(carId))
                    .driverId(id)
                    .period(resultSet.getInt(7))
                    .status(resultSet.getString(8))
                    .payment(resultSet.getInt(5))
                    .beginDay(resultSet.getObject(6).toString())
                    .id(resultSet.getInt(1))
                    .build();
            return offer;
        }
    }

    @Override
    public List<Offer> getAllPast() throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        List<Offer> pastOffers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where (offer.status = ? or offer.status = ?)")) {
            statement.setString(1, "Declined");
            statement.setString(2, "Finished");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                CarServiceImpl carService = new CarServiceImpl();
                pastOffers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(resultSet.getInt(2))
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .id(resultSet.getInt(1))
                        .build());
            }
        }
        return pastOffers;
    }

    public List<Offer> getAllPresent() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        List<Offer> presentOffers = new ArrayList<>();
        int carId = 0;
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             PreparedStatement statement = connection.prepareStatement(
                     "select * from offer where (offer.status = ? or offer.status = ?)")) {
            statement.setString(1, "Not paid");
            statement.setString(2, "In progress");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                CarServiceImpl carService = new CarServiceImpl();
                presentOffers.add(Offer.builder()
                        .car(carService.get(carId))
                        .driverId(resultSet.getInt(2))
                        .period(resultSet.getInt(7))
                        .status(resultSet.getString(8))
                        .payment(resultSet.getInt(5))
                        .beginDay(resultSet.getObject(6).toString())
                        .id(resultSet.getInt(1))
                        .build());
            }
        }
        return presentOffers;
    }
}
