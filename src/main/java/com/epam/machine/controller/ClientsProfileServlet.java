package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClientsProfileServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletRequest.getRequestDispatcher("/clientsProfile.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong" + err.getMessage());
        }
    }
}