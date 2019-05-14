package com.epam.machine.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.epam.machine.entity.Offer;
import com.epam.machine.service.OfferServiceImpl;
import org.apache.log4j.Logger;

public class AdminCertainOrderServlet extends HttpServlet {
    final static Logger logger = Logger.getLogger(AdminCertainOrderServlet.class);

    private OfferServiceImpl offerService = new OfferServiceImpl();

    private int offerIdInList;
    private List<Offer> offers;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            offers = offerService.getAll();
            offerIdInList = Integer.parseInt(request.getParameter("val"));

            request.getRequestDispatcher("/adminCertainOrder.jsp").forward(request, response);
        } catch (ServletException | IOException | SQLException | ClassNotFoundException err) {
            logger.error("Something is wrong. Game over. Try again. " + err.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        int statusId = Integer.parseInt(request.getParameter("status"));
        String status = null;
        try {
            status = offerService.getOffer(offerIdInList).getStatus();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (statusId == 1) {
            status = "Unexpectedly disappeared";
        }
        if (statusId == 2) {
            status = "In progress";
        }
        if (statusId == 3) {
            status = "Finished";
        }
        if (statusId == 4) {
            status = "Declined";
        }

        try {
            offerService.update(offerIdInList, status);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            response.sendRedirect("/admin/1/orders");
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    }
}
