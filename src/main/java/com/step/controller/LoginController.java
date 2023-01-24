package com.step.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final int userId = 1;
    private final String userName = "admin";
    private final String password = "pass";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    /**
     * Optional: we can use cookies if we want to store the user related data
     * Example:
     * Cookie userName = new Cookie("user", user);
     * userName.setMaxAge(15);
     * response.addCookie(userName);
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // get request parameters for userID and password
        String user = request.getParameter("user");
        String pwd = request.getParameter("pwd");

        // Read the user from the database
        if (userName.equals(user) && password.equals(pwd)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("userName", "admin");
            // Setting session to expiry in 15 seconds
            session.setMaxInactiveInterval(15);
            response.sendRedirect("index.jsp");
        } else {
            request.setAttribute("error", "Wrong user name and/or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
