package com.epam.machine.controller;

import com.epam.machine.service.AdminService;
import com.epam.machine.service.AdminServiceImpl;
import com.epam.machine.service.ClientService;
import com.epam.machine.service.ClientServiceImpl;
import com.epam.machine.util.Role;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(LoginServlet.class);

    private HttpSession session;
    private ClientService clientServiceImpl = new ClientServiceImpl();
    private AdminService adminServiceImpl = new AdminServiceImpl();

    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        response.setContentType("text/html");
        try {
            if (adminServiceImpl.adminLoginCheck(username,password)) {
                session = request.getSession();
                session.setAttribute("login", username);
                session.setAttribute("role", Role.ADMIN);
                response.sendRedirect("/admin/profile");
            } else if (clientServiceImpl.clientLoginCheck(username,password)) {
                session = request.getSession();
                session.setAttribute("login", username);
                session.setAttribute("role", Role.CUSTOMER);
                response.sendRedirect("/clients/profile");
            } else {
                request.setAttribute("fail", 1);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (IOException | ServletException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
    }
}
