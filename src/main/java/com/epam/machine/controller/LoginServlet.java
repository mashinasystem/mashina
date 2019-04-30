package com.epam.machine.controller;

import com.epam.machine.repository.LoginCheckRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

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
            int check = LoginCheckRepository.checkLog(username, password);
            if (check == 1) {
                session = request.getSession();
                session.setAttribute("login", username);
                response.sendRedirect("/clients/1/profile");
            } else if (check == 0) {
                request.setAttribute("fail", 1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else if (check == 2) {
                session = request.getSession();
                session.setAttribute("login", username);
                response.sendRedirect("/clients/1/profile");
                System.out.println("Admin");
            }
        } catch (IOException | ServletException | ClassNotFoundException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
