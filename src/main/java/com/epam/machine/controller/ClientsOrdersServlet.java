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

            List<Offer> pastOffers = offerService.getPast(login);
            request.setAttribute("pastOffers", pastOffers);

            List<Offer> presentOffers = offerService.getPresent(login);
            request.setAttribute("presentOffers", presentOffers);

            List<Ticket> tickets = ticketService.get(login);
            request.setAttribute("tickets", tickets);

            request.getRequestDispatcher("/clientsOrders.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        boolean ifNotNullTicket = true;
        boolean ifNotNullOffer = true;

        try {
            int ticketId = Integer.parseInt(request.getParameter("currentTicketId"));
        } catch (NumberFormatException err) {
            ifNotNullTicket = false;
        }

        try {
            int OfferId = Integer.parseInt(request.getParameter("val"));
        } catch (NumberFormatException err) {
            ifNotNullOffer = false;
        }

        if (ifNotNullOffer) {
            try {
                int offerId = Integer.parseInt(request.getParameter("val"));
                offerService.update(offerId, "Declined");
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        if (ifNotNullTicket) {
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


            } catch (NumberFormatException err) {
                logger.error("Incorrect input. " + err.getMessage());
            }
        }
        try {
            response.sendRedirect("/clients/1/orders");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}