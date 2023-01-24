package com.step.controller;

import com.step.model.Employee;
import com.step.model.EmployeeModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

public class AddController extends HttpServlet {
    // Implicit servletele nu raspund la nici un tip de apeluri
    // GET, POST, PUT, DELETE, PATCH


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       resp.sendRedirect("add.jsp");


//        RequestDispatcher dispatcher = req.getRequestDispatcher("add.jsp");
//        dispatcher.forward(req, resp);

        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String birthdate = req.getParameter("birthdate");
        System.out.println(name + surname + birthdate);
        EmployeeModel model = EmployeeModel.getInstance();
        model.add(new Employee(name, surname, LocalDate.parse(birthdate)));
        req.getRequestDispatcher("add.jsp").forward(req, resp);
    }
}
