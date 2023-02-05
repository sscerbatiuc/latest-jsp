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

//    private List<Employee> employeeList = new ArrayList<>();

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

    // 100
    // 99
    // page 10

    public List<Employee> getPage(int page) { // 2
        // Employee, Employee, Employee, Employee, ...  Employee, Employee, Employee
//        int to = page * rowsPerPage; // 10 20 30
//        int from = to - rowsPerPage; // 0  10
//        // Aici verificam daca to in general exista, daca nu, noi luam numarul total ca numarul 'TO'
//        if(to >= employeeList.size()) {
//            to = employeeList.size(); // 15
//        }
//        return employeeList.subList(from, to);
        return dao.findPage(page, rowsPerPage);
    }

    public long getTotalPages() {
        long count = this.dao.countAll();
        long numberOfPages = count / rowsPerPage;
        // Daca avem 10 elemente (impartim la 10) = 1 pagina,
        // 23/10 = 2.3, 35/10 = 3.5
        long rest = count % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public long getTotalPages(String filter) {
//        List<Employee> filtered = new ArrayList<>();
//        for(Employee employee: this.employeeList) {
//            if(employee.getName().contains(filter) || employee.getSurname().contains(filter)){
//                filtered.add(employee);
//            }
//        }
        long count = dao.countAll(filter);
        long numberOfPages = count / rowsPerPage;
        long rest = count % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public List<Employee> search(String searchBy, int page) {
//        List<Employee> filtered = new ArrayList<>();
//        for(Employee employee: this.employeeList) {
//            if(employee.getName().contains(searchBy) || employee.getSurname().contains(searchBy)){
//                filtered.add(employee);
//            }
//        }
//        int to = page * rowsPerPage;
//        int from = to - rowsPerPage;
//        if(to >= filtered.size()){
//            to = filtered.size();
//        }
        return dao.findPage(page, rowsPerPage, searchBy);
    }
}
