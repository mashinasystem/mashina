package com.epam.machine.controller;

import com.epam.machine.entity.Car;
import com.epam.machine.service.CarService;
import com.epam.machine.service.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class NewCarServlet extends HttpServlet {
    private CarService carService = new CarServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/newCar.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String marque = request.getParameter("marque");
        String number = request.getParameter("number");
        String model = request.getParameter("model");

        try {
            carService.create(Car.builder()
                .marque(marque)
                .model(model)
                .number(number)
                .build());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            response.sendRedirect("/admin/cars");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
