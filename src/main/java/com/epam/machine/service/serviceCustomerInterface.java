package com.epam.machine.service;

public interface serviceCustomerInterface {

    String readFromDB(int id);
    void createClient();
    void deleteClient(int id);
    String writeToDB(int id);
    void updateClient(int id);

    void changeFullName(int id);
    void changeLogen(int id);
    void chagePassword(int id);
    void changeDriverCard(int id);
    void changePhoneNumber(int id);
    void changeEMail(int id);
    void changePassport(int id);



}
