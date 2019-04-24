package com.epam.machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        } catch(ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }
}