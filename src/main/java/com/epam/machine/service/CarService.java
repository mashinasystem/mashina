package com.epam.machine.service;

import com.epam.machine.entity.Car;

import java.sql.SQLException;

public interface CarService {

    Car get(int id) throws SQLException, ClassNotFoundException;

    void create(Car car);

    void delete(int id);

    void update(int id);
}
