package com.epam.machine.service;

import com.epam.machine.entity.Ticket;
import com.epam.machine.repository.ClientRepositoryImpl;
import com.epam.machine.repository.TicketRepository;
import com.epam.machine.repository.TicketRepositoryImpl;
import lombok.NoArgsConstructor;

import java.sql.SQLException;
import java.util.List;

public class TicketServiceImpl implements TicketService {

    private ClientRepositoryImpl clientRepository = new ClientRepositoryImpl();
    private TicketRepository ticketRepository = new TicketRepositoryImpl();

    @Override
    public List<Ticket> get(int id) throws ClassNotFoundException, SQLException {
        return ticketRepository.get(id);
    }

    @Override
    public List<Ticket> get(String login) throws ClassNotFoundException, SQLException {
        int id = clientRepository.getIdByLogin(login);
        return this.get(id);
    }

    @Override
    public void create(Ticket ticket) throws SQLException, ClassNotFoundException {
        if (ticket != null) {
            ticketRepository.create(ticket);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void delete(int id) throws ClassNotFoundException, SQLException {
        ticketRepository.delete(id);
    }

    @Override
    public void update(Ticket ticket) throws ClassNotFoundException, SQLException {
        if (ticket != null) {
            ticketRepository.update(ticket.getId(), ticket.getIsPaid());
        } else {
            throw new NullPointerException();
        }
    }
}
