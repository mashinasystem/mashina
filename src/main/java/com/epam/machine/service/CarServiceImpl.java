package com.epam.machine.service;

import com.epam.machine.entity.Car;
import com.epam.machine.repository.CarRepositoryImpl;
import java.sql.SQLException;
import java.util.List;

public class CarServiceImpl implements CarService {
    private CarRepositoryImpl carRepository = new CarRepositoryImpl();
    @Override
    public Car get(int id) throws SQLException, ClassNotFoundException {
        return carRepository.get(id);
    }

    @Override
    public void create(Car car) throws SQLException, ClassNotFoundException {
        carRepository.create(car);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(int id) {

    }

    @Override
    public List<Car> getAll() throws SQLException, ClassNotFoundException {
        return carRepository.getAll();
    }
}
