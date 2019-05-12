package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.machine.entity.Offer;
import com.epam.machine.service.OfferService;
import com.epam.machine.service.OfferServiceImpl;
import org.apache.log4j.Logger;

public class AdminOrdersServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminOrdersServlet.class);
    private OfferService offerService = new OfferServiceImpl();

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Offer> offers = new ArrayList<>();
            List<Offer> pastOffers = new ArrayList<>();
            List<Offer> presentOffers = new ArrayList<>();

            offers = offerService.getAll();

            for (int i = 0; i < offers.size(); i++) {
                if (offers.get(i).getStatus().equals("Declined") || offers.get(i).getStatus().equals("Finished")) {
                    pastOffers.add(offers.get(i));
                } else {
                    presentOffers.add(offers.get(i));
                }
            }

            request.setAttribute("pastOffers", pastOffers);
            request.setAttribute("presentOffers", presentOffers);

            request.getRequestDispatcher("/adminOrders.jsp").forward(request, response);
        } catch(ServletException | IOException | SQLException | ClassNotFoundException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }
}