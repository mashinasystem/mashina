package com.epam.machine.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {

    public void init(FilterConfig fConfig) {
        ServletContext context = fConfig.getServletContext();
        context.log("RequestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("role") != null) {
            String role = session.getAttribute("role").toString();
            if (role.equals("admin")) {
                chain.doFilter(request, response);
            } else {
                res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/page403.jsp"));
            }
        } else {
            res.sendRedirect(res.encodeRedirectURL(req.getContextPath() + "/page403.jsp"));
        }
    }

    @Override
    public void destroy() {

    }
}