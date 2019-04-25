package com.epam.machine.service;

import com.epam.machine.entity.Client;
import com.epam.machine.repository.ClientRepositoryImpl;
import lombok.Data;

@Data
public class СlientServiceImpl implements ClientService {

    private ClientRepositoryImpl clientRepositoryImpl = new ClientRepositoryImpl();

    @Override
    public void create(Client client) {
        if (client != null) {
            clientRepositoryImpl.create(client);
        } else {
            throw new IllegalArgumentException();
        }

    }

    @Override
    public void delete(int id)
    {
        clientRepositoryImpl.deleteRecoed(id);
    }

    @Override
    public void update(Client client)
    {
        int id = clientRepositoryImpl.getIdByLogin(client.getLogin());
        clientRepositoryImpl.update(id,client);
    }

    @Override
    public Client get(String login)
    {
        int id = clientRepositoryImpl.getIdByLogin(login);
        Client client = clientRepositoryImpl.get(id);
        return client;
    }

}
