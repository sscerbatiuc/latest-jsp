package com.step.controller;

import com.step.model.EmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// TODO: afisarea, adaugarea, editarea si stergerea

public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchBy = req.getParameter("search");
        if (searchBy != null) {
            this.search(req, resp);
        } else {
            this.displayPage(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        EmployeeModel model = EmployeeModel.getInstance();
        String requestedPage = req.getParameter("p");
        if(requestedPage != null) {
            // TODO de fixat logica pentru cazul cand pagina nu exista!
            page = Integer.parseInt(requestedPage);
        }
        String searchBy = req.getParameter("search");

        req.setAttribute("list",  model.search(searchBy, page));
        req.setAttribute("activePage", page);
        req.setAttribute("totalPages", model.getTotalPages(searchBy));
        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    private void displayPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page = 1;
        String requestedPage = req.getParameter("p");
        if(requestedPage != null) {
            // TODO de fixat logica pentru cazul cand pagina nu exista!
            page = Integer.parseInt(requestedPage);
        }
        // 2. Transmitem pagina la EmployeeModel si el ne returneaza o parte din date
        EmployeeModel model = EmployeeModel.getInstance();

        // 3. Informatia din employee model se seteaza pe obiectul request

        long totalPages = model.getTotalPages();

        req.setAttribute("list",  model.getPage(page));
        req.setAttribute("activePage", page);
        req.setAttribute("totalPages", totalPages);

        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }

    // POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String searchBy = req.getParameter("search");
//        EmployeeModel model = EmployeeModel.getInstance();
//        List<Employee> list = model.search(searchBy);
//        req.setAttribute("list",  list);
//        req.setAttribute("activePage", 1);
//        int totalPages = model.getTotalPages();
//        req.setAttribute("totalPages", totalPages);
//        req.getRequestDispatcher("list.jsp").forward(req,resp);
    }
}
