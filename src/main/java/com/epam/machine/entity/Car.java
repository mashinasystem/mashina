package com.epam.machine.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Car {
    private int id;
    private String number;
    private String model;
    private String marque;
}
