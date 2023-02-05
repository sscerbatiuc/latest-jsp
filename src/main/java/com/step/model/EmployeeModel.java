package com.step.model;

import java.time.LocalDate;
import java.util.List;

public class EmployeeModel {

    private final EmployeeDAO dao = new EmployeeDAO();

    private final int rowsPerPage = 10;

    // Singleton
    private static final EmployeeModel instance = new EmployeeModel();

    public static EmployeeModel getInstance(){
        return instance;
    }

    private EmployeeModel() {}

    public void add(Employee employee) {
        this.dao.create(employee);
    }

    public Employee get(int id) {
        return this.dao.findById(id);
    }

    public void edit(Integer id, String name, String surname, LocalDate birthdate) {
        dao.update(id, name, surname, birthdate);
    }

    public void remove(int id) {
        dao.delete(id);
    }

    public List<Employee> getPage(int page) { // 2
        return dao.findPage(page, rowsPerPage);
    }

    public long getTotalPages() {
        long count = this.dao.countAll();
        long numberOfPages = count / rowsPerPage;
        long rest = count % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public long getTotalPages(String filter) {
        long count = dao.countAll(filter);
        long numberOfPages = count / rowsPerPage;
        long rest = count % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public List<Employee> search(String searchBy, int page) {
        return dao.findPage(page, rowsPerPage, searchBy);
    }
}
