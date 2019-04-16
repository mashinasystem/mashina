package com.epam.machine.Controller;

import com.epam.machine.Controller.util.loginCheck;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class loginServlet extends HttpServlet{
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("LoginForm.jsp").forward(request, response);
        } catch(ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        try {
            if (loginCheck.checkLog(username, password)) {
                response.sendRedirect("user");
            } else {
                request.getRequestDispatcher("LoginFail.jsp").forward(request, response);
            }
        } catch(IOException | ServletException err) {
            System.out.println("Something is wrong. Game over. Try again");
        }
    }
}
