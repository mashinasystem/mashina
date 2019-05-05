package com.epam.machine.filter;

import com.epam.machine.util.Role;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ClientsFilter implements Filter {

    public void init(FilterConfig fConfig) {
        ServletContext context = fConfig.getServletContext();
        context.log("RequestLoggingFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("role") != null) {
            Role role = (Role) session.getAttribute("role");
            if (role.equals(Role.CUSTOMER)) {
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