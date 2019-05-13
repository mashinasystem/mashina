package com.epam.machine.controller;

import com.epam.machine.entity.Offer;
import com.epam.machine.entity.Ticket;
import com.epam.machine.service.OfferServiceImpl;
import com.epam.machine.service.TicketServiceImpl;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientsOrdersServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminCertainOrderServlet.class);

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
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int ticketId = Integer.parseInt(request.getParameter("currentTicketId"));

            try {
                ticketService.update(Ticket.builder()
                        .id(ticketId)
                        .isPaid(true)
                        .build());
            } catch (SQLException | ClassNotFoundException e) {
                logger.error(e.getMessage());
            }

            try {
                response.sendRedirect("/clients/1/orders");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }

        } catch (NumberFormatException err){
            logger.error("Incorrect input. " + err.getMessage());
        }
    }
}