package com.step.controller;

import com.step.model.Employee;
import com.step.model.EmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestId = req.getParameter("id");
        if(requestId == null) {
            resp.sendRedirect("list");
        } else {
            Employee employee = EmployeeModel.getInstance().get(Integer.parseInt(requestId));
            req.setAttribute("fullName", employee.getName() + " " + employee.getSurname());
            req.getRequestDispatcher("delete.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestId = req.getParameter("id");
        if(requestId != null) {
            EmployeeModel.getInstance().remove(Integer.parseInt(requestId));
            resp.sendRedirect("list");
        }
    }
}

