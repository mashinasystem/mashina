package com.epam.machine.entity;

import lombok.Data;

@Data
public class Client {
    private int id;
    private String fullName;
    private String passport;
    private String driverCard;
    private String phoneNumber;
    private String eMail;
    private String login;
    private String password;
}
