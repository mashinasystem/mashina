package com.epam.machine.controller;

import com.epam.machine.entity.Client;
import com.epam.machine.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class RegisterServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(RegisterServlet.class);
    private ClientServiceImpl clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String fullName = request.getParameter("fullName");
        String passport = request.getParameter("passport");
        String driverCard = request.getParameter("driverCard");
        String phoneNumber = request.getParameter("phoneNumber");
        String eMail = request.getParameter("eMail");
        String password = request.getParameter("password");

        try {
            clientService.create(Client.builder()
                    .fullName(fullName)
                    .passport(passport)
                    .driverCard(driverCard)
                    .phoneNumber(phoneNumber)
                    .eMail(eMail)
                    .password(password)
                    .build());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }

        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}