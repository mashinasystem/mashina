package com.epam.machine.service;

import com.epam.machine.entity.Client;
import com.epam.machine.repository.ClientRepositoryImplementation;
import lombok.Data;

@Data
public class СlientServiceImplementation implements ClientService {

    private Client client = new Client();
    private ClientRepositoryImplementation clientRepositoryImplementation =
            new ClientRepositoryImplementation();


    @Override
    public void create(String input) {
        if(input != "") {
            client = addInfoToClient(input,client);
            clientRepositoryImplementation.createRecord(client);
        }
        else
        {
            throw new IllegalArgumentException();
        }




    }

    @Override
    public void delete(int id)
    {
        clientRepositoryImplementation.deleteRecoed(id);
    }

    @Override
    public void update(int id,String input)
    {

    }

    @Override
    public Client getData(int id)
    {
        String input = clientRepositoryImplementation.getRecord(id);
        client = addInfoToClient(input,client);
        return client;
    }

    private Client addInfoToClient(String input,Client client)
    {
        String[] data = input.split(" ");
        try {
            client.setId(Integer.parseInt(data[0]));
            client.setFullName(data[1]);
            client.setPassport(data[2]);
            client.setDriverCard(data[3]);
            client.setPhoneNumber(data[4]);
            client.setEMail(data[5]);
            client.setLogin(data[6]);
            client.setPassword(data[7]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        return client;
    }
}
