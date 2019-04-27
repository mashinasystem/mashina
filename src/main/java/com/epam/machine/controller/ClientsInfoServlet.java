package com.epam.machine.controller;

import com.epam.machine.entity.Client;
import com.epam.machine.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class ClientsInfoServlet extends HttpServlet {
    @Override
    public void doGet (HttpServletRequest request, HttpServletResponse response) {
        try {
            ClientServiceImpl clientServiceimpl = new ClientServiceImpl();
            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();
            Client client = clientServiceimpl.get(login);
            request.setAttribute("fail", 0);
            request.getRequestDispatcher("/clientsInfo.jsp").forward(request, response);
            request.setAttribute("name", client.getFullName());
        } catch(ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
