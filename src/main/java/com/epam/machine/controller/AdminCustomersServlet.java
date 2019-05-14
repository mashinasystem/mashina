package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.epam.machine.entity.Client;
import com.epam.machine.entity.Ticket;
import com.epam.machine.service.ClientServiceImpl;
import com.epam.machine.service.TicketServiceImpl;
import org.apache.log4j.Logger;

public class AdminCustomersServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminCustomersServlet.class);

    private TicketServiceImpl ticketService = new TicketServiceImpl();
    private ClientServiceImpl clientService = new ClientServiceImpl();


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Client> clients = clientService.getAll();
            request.setAttribute("clients", clients);

            List<Ticket> tickets = new ArrayList<>();
            List<String> clientNames = new ArrayList<>();

            for (Client client : clients) {
                List<Ticket> ticketsForHelp = ticketService.get(client.getId());
                for (Ticket oneTicketForHelp : ticketsForHelp) {
                    clientNames.add(client.getFullName());
                    tickets.add(oneTicketForHelp);
                }
            }
            request.setAttribute("names", clientNames);
            request.setAttribute("tickets", tickets);

            request.getRequestDispatcher("/adminCustomers.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            int driverId = Integer.parseInt(request.getParameter("driverId"));
            int ticketCost = Integer.parseInt(request.getParameter("ticketCost"));

            try {
                ticketService.create(Ticket.builder()
                        .driverId(driverId)
                        .isPaid(false)
                        .cost(ticketCost)
                        .build());
            } catch (SQLException | ClassNotFoundException e) {
                logger.error(e.getMessage());
            }

            try {
                response.sendRedirect("/admin/1/customers");
            } catch (IOException e) {
                logger.error(e.getMessage());
            }

        } catch (NumberFormatException err){
            logger.error("Incorrect input. " + err.getMessage());
        }
    }
}