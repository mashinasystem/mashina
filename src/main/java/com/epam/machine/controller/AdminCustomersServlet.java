package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

public class AdminCustomersServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminCustomersServlet.class);

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/adminCustomers.jsp").forward(request, response);
        } catch(ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }
}