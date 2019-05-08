package com.epam.machine.service;

import com.epam.machine.entity.Ticket;
import java.sql.SQLException;
import java.util.List;

public interface TicketService {

    List<Ticket> get(int id) throws ClassNotFoundException, SQLException;

    List<Ticket> get(String login) throws ClassNotFoundException, SQLException;

    void create(Ticket ticket) throws SQLException, ClassNotFoundException;

    void delete(int id) throws ClassNotFoundException, SQLException;

    void update(Ticket ticket) throws ClassNotFoundException, SQLException;
}
