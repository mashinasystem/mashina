package com.epam.machine.controller;

import com.epam.machine.util.LoginCheck;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again", err);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        try {
            if (LoginCheck.checkLog(username, password)) {
                response.sendRedirect("/clients/1/profile");
            } else {
                request.setAttribute("fail", 1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException err) {
            logger.error("Something is wrong. Game over. Try again", err);
        }
    }
}
