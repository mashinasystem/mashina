package com.epam.machine.controller;

import com.epam.machine.util.LoginCheck;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private HttpSession session;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        try {
            if (LoginCheck.checkLog(username, password)) {
                session = request.getSession();
                session.setAttribute("login", username);
                response.sendRedirect("/clients/1/profile");
            } else {
                request.setAttribute("fail", 1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }
}
