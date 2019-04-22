package com.epam.machine.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Customer {

    @Getter
    @Setter
    private int id;
    private String fullname;
    private String passport;
    private String driverCard;
    private String phoneNumber;
    private String eMail;
    private String login;
    private String password;


}
