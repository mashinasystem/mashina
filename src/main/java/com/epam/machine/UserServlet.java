package com.epam.machine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try {
            httpServletRequest.getRequestDispatcher("/userform.jsp").forward(httpServletRequest, httpServletResponse);
        } catch (ServletException | IOException err) {
            System.out.println("Something is wrong" + err.getMessage());
        }
    }
}