package com.epam.machine.controller;

import com.epam.machine.entity.Admin;
import com.epam.machine.service.AdminService;
import com.epam.machine.service.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class AdminInfoServlet extends HttpServlet {

    AdminService adminServiceImpl = new AdminServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();
            Admin admin = adminServiceImpl.get(login);
            request.setAttribute("name", admin.getName());
            request.setAttribute("login", admin.getLogin());
            request.setAttribute("password", admin.getPassword());
            request.getRequestDispatcher("/adminInfo.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
