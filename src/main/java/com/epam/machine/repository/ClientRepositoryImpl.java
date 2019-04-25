package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Data;

@Data
public class ClientRepositoryImpl implements ClientRepository{

    @Override
    public Client get(int id) {

        return null;
    }

    @Override
    public void create(Client client) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id, Client client) {

    }

    @Override
    public int getIdByLogin(String login) {
        return 0;
    }
}
