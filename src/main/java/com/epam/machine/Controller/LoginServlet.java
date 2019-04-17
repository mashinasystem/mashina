package com.epam.machine.Controller;

import com.epam.machine.Controller.util.LoginCheck;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch(ServletException | IOException err) {
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
                response.sendRedirect("user");
            } else {
                request.setAttribute("fail", 1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch(IOException | ServletException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        }
    }
}
