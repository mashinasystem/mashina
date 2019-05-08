package com.epam.machine.service;

import com.epam.machine.entity.Client;
import com.epam.machine.repository.ClientRepository;
import com.epam.machine.repository.ClientRepositoryImpl;
import lombok.NoArgsConstructor;

import java.sql.SQLException;

@NoArgsConstructor
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepositoryImpl = new ClientRepositoryImpl();

    @Override
    public void create(Client client) throws SQLException, ClassNotFoundException {
        if (client != null) {
            clientRepositoryImpl.create(client);
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        clientRepositoryImpl.delete(id);
    }

    @Override
    public void update(Client client) throws SQLException, ClassNotFoundException {
        if (client != null) {
            int id = clientRepositoryImpl.getIdByLogin(client.getEMail());
            clientRepositoryImpl.update(id, client);
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public Client get(String login) throws SQLException, ClassNotFoundException {
        int id = clientRepositoryImpl.getIdByLogin(login);
        return clientRepositoryImpl.get(id);
    }

}
