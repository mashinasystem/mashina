package com.epam.machine.controller;

import com.epam.machine.entity.Offer;
import com.epam.machine.entity.Ticket;
import com.epam.machine.service.OfferServiceImpl;
import com.epam.machine.service.TicketServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientsOrdersServlet extends HttpServlet {

    private OfferServiceImpl offerService = new OfferServiceImpl();
    private TicketServiceImpl ticketService = new TicketServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();

            List<Offer> offers = offerService.get(login);
            request.setAttribute("offers", offers);

            List<Ticket> tickets = ticketService.get(login);
            request.setAttribute("tickets", tickets);

            request.getRequestDispatcher("/clientsOrders.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }
}