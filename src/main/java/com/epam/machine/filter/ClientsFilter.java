package com.epam.machine.filter;

import java.io.IOException;
import java.sql.Timestamp;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ClientsFilter implements Filter {

    HttpSession session = request.getSession();
    private String role = (String) session.getAttribute("role");

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("RequestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.context.log("TimeStamp :" + timestamp + " - IP Address" + req.getRemoteAddr());

        // pass the request along the filter chain
        if (role.equals("customer")) {
            chain.doFilter(request, response);
        } else {
//            response.sendRedirect("/login");
        }

        @Override
        public void destroy() {
            //we can close resources here
        }

    }
}