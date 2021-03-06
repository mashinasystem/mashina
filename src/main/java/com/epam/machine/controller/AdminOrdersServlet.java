package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.epam.machine.entity.Offer;
import com.epam.machine.entity.Client;
import com.epam.machine.service.OfferService;
import com.epam.machine.service.ClientService;
import com.epam.machine.service.OfferServiceImpl;
import com.epam.machine.service.ClientServiceImpl;
import org.apache.log4j.Logger;

public class AdminOrdersServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminOrdersServlet.class);

    private OfferService offerService = new OfferServiceImpl();
    private ClientService clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Offer> pastOffers = offerService.getAllPast();
            request.setAttribute("pastOffers", pastOffers);

            List<Offer> presentOffers = offerService.getAllPresent();
            request.setAttribute("presentOffers", presentOffers);

            List<Client> clients = clientService.getAll();
            request.setAttribute("clients", clients);

            request.getRequestDispatcher("/adminOrders.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }
}