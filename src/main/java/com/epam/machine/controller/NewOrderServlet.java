package com.epam.machine.controller;

import com.epam.machine.entity.Offer;
import com.epam.machine.service.CarServiceImpl;
import com.epam.machine.service.ClientServiceImpl;
import com.epam.machine.service.OfferServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class NewOrderServlet extends HttpServlet {
    private OfferServiceImpl offerService = new OfferServiceImpl();
    private CarServiceImpl carService = new CarServiceImpl();
    private ClientServiceImpl clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/newOrder.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int carId = Integer.parseInt(request.getParameter("carId"));
        int period = Integer.parseInt(request.getParameter("period"));
        HttpSession session = request.getSession();
        String login = session.getAttribute("login").toString();
        try {
            offerService.create(Offer.builder()
                .car(carService.get(carId))
                .payment(period * 200)
                .period(period)
                .status("In progress")
                .driverId(clientService.get(login).getId())
                .build());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/clients/1/orders");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
