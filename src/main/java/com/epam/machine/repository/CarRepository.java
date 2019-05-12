package com.epam.machine.repository;

import com.epam.machine.entity.Car;

import java.sql.SQLException;
import java.util.List;

interface CarRepository {

    Car get(int id) throws ClassNotFoundException, SQLException;

    void create(Car car) throws ClassNotFoundException, SQLException;

    void delete(int id);

    void update(int id);

    List<Car> getAll() throws ClassNotFoundException, SQLException;
}
