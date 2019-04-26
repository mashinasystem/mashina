package com.epam.machine.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private int id;
    private String fullName;
    private String passport;
    private String driverCard;
    private String phoneNumber;
    private String eMail;
    private String login;
    private String password;

    public Client of(String fullName, String passport,String driverCard ,String phoneNumber, String eMail,String login, String password){
        return Client.builder()
                .fullName(fullName)
                .passport(passport)
                .driverCard(driverCard)
                .phoneNumber(phoneNumber)
                .eMail(eMail)
                .login(login)
                .password(password)
                .build();
    }
}
