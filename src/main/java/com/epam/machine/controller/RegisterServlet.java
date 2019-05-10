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

public class RegisterServlet extends HttpServlet {
    private ClientServiceImpl clientService = new ClientServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
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
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}