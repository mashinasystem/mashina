package com.epam.machine.repository;

import com.epam.machine.entity.Ticket;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TicketRepositoryImpl implements TicketRepository {

    final static private String DATA_BASE_URL = "jdbc:postgresql://localhost:5432/Car";
    final static private String JDBC_DRIVER = "org.postgresql.Driver";
    final static private String ADMIN = "Admin";
    final static private String PASSWORD = "qwerty";

    @Override
    public List<Ticket> get(int driverId) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        ResultSet resultSet;
        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql;
            if (driverId < 0) {
                sql = "SELECT * FROM ticket;";
            } else {
                sql = "SELECT * FROM ticket WHERE ticket.driver_id = " + driverId + ";";
            }
            resultSet = statement.executeQuery(sql);
            List<Ticket> tickets = new ArrayList<>();
            while (resultSet.next()) {
                tickets.add(Ticket.builder()
                        .id(resultSet.getInt(1))
                        .driverId(resultSet.getInt(2))
                        .isPaid(resultSet.getBoolean(3))
                        .cost(resultSet.getInt(4))
                        .build());
            }
            return tickets;
        }
    }

    public List<Ticket> get() throws ClassNotFoundException, SQLException {
        return this.get(-1);
    }

    @Override
    public void create(Ticket ticket) throws SQLException, ClassNotFoundException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "INSERT INTO ticket (driver_id,is_paid,cost) VALUES (" + "\'"
                    + ticket.getDriverId() + "\',\'" +
                    ticket.getIsPaid() + "\',\'" +
                    ticket.getCost() + "\');";

            statement.executeUpdate(sql);
        }
    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "DELETE FROM ticket WHERE ticket.id = " + id + ";";
            statement.executeUpdate(sql);
        }
    }

    @Override
    public void update(int id, boolean paid) throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);

        try (Connection connection = DriverManager.getConnection(DATA_BASE_URL, ADMIN, PASSWORD);
             Statement statement = connection.createStatement()) {
            String sql = "UPDATE ticket" +
                    " SET is_paid = " + paid +
                    " WHERE id = " + id + ";";
            statement.executeUpdate(sql);
        }
    }
}
