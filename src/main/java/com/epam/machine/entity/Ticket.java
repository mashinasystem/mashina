package com.epam.machine.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ticket {
    private int id;
    private int driverId;
    private boolean isPaid;
    private int cost;
}
