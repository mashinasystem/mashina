package com.epam.machine.service;

import com.epam.machine.entity.Client;
import com.epam.machine.repository.ClientRepositoryImpl;
import lombok.Data;

import java.sql.SQLException;

@Data
public class ClientServiceImpl implements ClientService {

    private ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

    @Override
    public void create(Client client) throws SQLException, ClassNotFoundException {
        if (client != null) {
            clientRepositoryImpl.create(client);
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        clientRepositoryImpl.delete(id);
    }

    @Override
    public void update(Client client) throws SQLException, ClassNotFoundException {
        int id = clientRepositoryImpl.getIdByLogin(client.getLogin());
        clientRepositoryImpl.update(id,client);
    }

    @Override
    public Client get(String login) throws SQLException, ClassNotFoundException {
        int id = clientRepositoryImpl.getIdByLogin(login);
        return clientRepositoryImpl.get(id);
    }

}
