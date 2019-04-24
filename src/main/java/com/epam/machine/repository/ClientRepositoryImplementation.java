package com.epam.machine.repository;

import com.epam.machine.entity.Client;
import lombok.Data;

@Data
public class ClientRepositoryImplementation implements ClientRepository{



    @Override
    public String getRecord(int id)
    {

        return null;
    }

    @Override
    public void createRecord(Client client) {

    }

    @Override
    public void deleteRecoed(int id) {

    }

    @Override
    public void updateRecord(int id, Client client) {

    }
}
