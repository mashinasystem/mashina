package com.epam.machine.repository;

import com.epam.machine.entity.Client;

public interface ClientRepository
{
    String getRecord(int id);
    void createRecord(int id, Client client);
    void deleteRecoed(int id);
    void updateRecord(int id,Client client);
}
