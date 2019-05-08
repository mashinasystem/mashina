package com.epam.machine.controller;

import com.epam.machine.entity.Offer;
import com.epam.machine.service.OfferServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CertainOrderServlet extends HttpServlet {
    private OfferServiceImpl offerService = new OfferServiceImpl();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            int offerId = Integer.parseInt(request.getParameter("val"));
            System.out.println(offerId);
            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();
            List<Offer> offers = offerService.get(login);
            request.setAttribute("offer", offers.get(offerId));
            request.getRequestDispatcher("/clientCertainOrder.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong. Game over. Try again" + err.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
