package com.epam.machine.service;

import com.epam.machine.entity.Car;

import java.sql.SQLException;
import java.util.List;

public interface CarService {

    Car get(int id) throws SQLException, ClassNotFoundException;

    void create(Car car) throws SQLException, ClassNotFoundException;

    void delete(int id);

    void update(int id);

    List<Car> getAll() throws SQLException, ClassNotFoundException;
}
