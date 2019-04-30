package com.epam.machine.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Offer {
    private int id;
    private int driverId;
    private int carId;
    private int payment;
    private int beginDay;
    private int period;
    private String status;
}
