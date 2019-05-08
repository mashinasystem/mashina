package com.epam.machine.repository;

import com.epam.machine.entity.Ticket;
import java.sql.SQLException;
import java.util.List;

public interface TicketRepository {

    List<Ticket> get(int id) throws ClassNotFoundException, SQLException;

    void create(Ticket ticket) throws SQLException, ClassNotFoundException;

    void delete(int id) throws ClassNotFoundException, SQLException;

    void update(int id, Ticket ticket) throws ClassNotFoundException, SQLException;
}
