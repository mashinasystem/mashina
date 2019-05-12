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
import org.apache.log4j.Logger;

public class CertainOrderServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(CertainOrderServlet.class);
    private OfferServiceImpl offerService = new OfferServiceImpl();
    private int offerIdInList;
    private List<Offer> offers;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            offerIdInList = Integer.parseInt(request.getParameter("val"));

            HttpSession session = request.getSession();
            String login = session.getAttribute("login").toString();

            offers = offerService.get(login);
            request.setAttribute("offer", offers.get(offerIdInList));

            request.getRequestDispatcher("/clientCertainOrder.jsp").forward(request, response);
        } catch (ServletException | IOException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        } catch (SQLException e) {
            logger.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int statusId = Integer.parseInt(request.getParameter("status"));
        String status = offers.get(offerIdInList).getStatus();

        if (statusId == 1) {
            status = "Declined";
        }

        offers.get(offerIdInList).setStatus(status);
        try {
            offerService.update(offers.get(offerIdInList).getId(), offers.get(offerIdInList));
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/clients/1/orders");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}