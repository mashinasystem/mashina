package com.epam.machine.repository;

import com.epam.machine.entity.Offer;
import lombok.Builder;
import lombok.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class OfferRepositroryImpl implements OfferRepository {
    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";

    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Override
    @Builder
    public List<Offer> get(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        List<Offer> offers = new ArrayList<>();
        int carId = 0;
        int payment = 0;
        int period = 0;
        String status = "";
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "SELECT * FROM offer WHERE offer.id = " + id + ";";
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                carId = resultSet.getInt(4);
                payment = resultSet.getInt(5);
                period = resultSet.getInt(7);
                status = resultSet.getString(8);
                offers.add(Offer.builder()
                        .carId(carId)
                        .driverId(id)
                        .period(period)
                        .status(status)
                        .payment(payment)
                        .build());
            }
        }
        return offers;
    }

    @Override
    public void create(Offer offer) {}

    @Override
    public void delete(int id) {}

    @Override
    public void update(int id) {}
}
