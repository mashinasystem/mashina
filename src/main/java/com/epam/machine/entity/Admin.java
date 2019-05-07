package com.epam.machine.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Admin {
    private int id;
    private String name;
    private String login;
    private String password;
}
