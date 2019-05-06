package com.epam.machine.repository;

import com.epam.machine.entity.Car;

import java.sql.SQLException;

interface CarRepository {

    Car get(int id) throws ClassNotFoundException, SQLException;

    void create(Car car);

    void delete(int id);

    void update(int id);
}
