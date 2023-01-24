package com.step.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
        this.context.log("AuthenticationFilter initialized");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        System.out.println("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);
        String userId = null;
        String userName = null;
        if(session != null) {
            //allow access only if session exists
            userId = session.getAttribute("userId") != null ? String.valueOf(session.getAttribute("userId")) : null;
            userName = session.getAttribute("userName") != null ? String.valueOf(session.getAttribute("userName")) : null;
            /* Optional: cookies */
            // String userName = null;
            // String sessionID = null;
            // Cookie[] cookies = req.getCookies();
            // if (cookies != null) {
            //     for (Cookie cookie : cookies) {
            //         if (cookie.getName().equals("employee-manager")) userName = cookie.getValue();
            //         if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
            //     }
            // }
        }

        if(uri.endsWith("login") || (session != null && userId != null && userName != null)){
            // pass the request along the filter chain
            chain.doFilter(request, response);
        } else {
            System.err.println("Unauthorized access request");
            res.sendRedirect("login");
        }

    }

    public void destroy() {
        //close any resources here
    }

}
