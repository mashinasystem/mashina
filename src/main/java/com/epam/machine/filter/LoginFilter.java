package com.epam.machine.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {

    public void init(FilterConfig fConfig) {
        ServletContext context = fConfig.getServletContext();
        context.log("RequestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("role") != null) {
            res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/"));
        } else {
            chain.doFilter(request, response);
        }
    }


    @Override
    public void destroy() {

    }
}