package com.epam.machine.controller;

import com.epam.machine.entity.Car;
import com.epam.machine.service.CarService;
import com.epam.machine.service.CarServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CarAdminServlet extends HttpServlet {
    private CarService carService = new CarServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();

            List<Car> cars = carService.getAll();
            request.setAttribute("cars", cars);

            request.getRequestDispatcher("/adminCars.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }
}
