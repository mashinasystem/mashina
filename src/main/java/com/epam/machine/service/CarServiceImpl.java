package com.epam.machine.service;

import com.epam.machine.entity.Car;
import com.epam.machine.repository.CarRepository;
import com.epam.machine.repository.CarRepositoryImpl;

import java.sql.SQLException;

public class CarServiceImpl implements CarService {
    CarRepository carRepository = new CarRepositoryImpl();
    @Override
    public Car get(int id) throws SQLException, ClassNotFoundException {
        return carRepository.get(id);
    }

    @Override
    public void create(Car car) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }
}
