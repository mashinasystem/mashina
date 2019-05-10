package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.apache.log4j.Logger;

public class AdminProfileServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminProfileServlet.class);

    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletRequest.getRequestDispatcher("/adminProfile.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }
}