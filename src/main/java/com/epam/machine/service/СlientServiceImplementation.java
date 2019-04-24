package com.epam.machine.service;

import com.epam.machine.entity.Client;

public class СlientServiceImplementation implements ClientService {

    private Client client = new Client();


    @Override
    public void create(String input) {
        String[] data = input.split(" ");


    }

    @Override
    public void delete(int id) {


    }

    @Override
    public void update(int id,String input) {

    }

    @Override
    public Client getData(int id) {

        return client;
    }
}
