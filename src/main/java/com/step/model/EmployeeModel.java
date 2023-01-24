package com.step.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel {

    private int rowsPerPage = 10;

    // Singleton
    private static EmployeeModel instance = new EmployeeModel();

    public static EmployeeModel getInstance(){
        return instance;
    }

    private List<Employee> employeeList = new ArrayList<>();

    private EmployeeModel() {
        for (int i = 0; i < 100; i++) {
            this.employeeList.add(new Employee(i, "John " + i, "Smith " + i, LocalDate.now()));
        }
    }

    private List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void add(Employee employee) {
        int nextId = this.employeeList.size();
        this.employeeList.add(new Employee(nextId, employee.getName(), employee.getSurname(), employee.getBirthdate()));
    }

    public Employee get(int id) {
        return this.employeeList.get(id);
    }

    public void edit(Integer id, String name, String surname, LocalDate birthdate) {
        employeeList.get(id).setName(name);
        employeeList.get(id).setSurname(surname);
        employeeList.get(id).setBirthdate(birthdate);
    }

    public void remove(int id) {
        int index = -1;
        for(int i = 0; i< employeeList.size(); i++) {
            if(employeeList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if(index != -1) {
            employeeList.remove(index);
        }
    }

    // 100
    // 99
    // page 10

    public List<Employee> getPage(int page) { // 2
        // Employee, Employee, Employee, Employee, ...  Employee, Employee, Employee
        int to = page * rowsPerPage; // 10 20 30
        int from = to - rowsPerPage; // 0  10
        // Aici verificam daca to in general exista, daca nu, noi luam numarul total ca numarul 'TO'
        if(to >= employeeList.size()) {
            to = employeeList.size(); // 15
        }
        return employeeList.subList(from, to);
    }

    public int getTotalPages() {
        int numberOfPages = this.employeeList.size() / rowsPerPage;
        // Daca avem 10 elemente (impartim la 10) = 1 pagina,
        // 23/10 = 2.3, 35/10 = 3.5
        int rest = this.employeeList.size() % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public int getTotalPages(String filter) {
        List<Employee> filtered = new ArrayList<>();
        for(Employee employee: this.employeeList) {
            if(employee.getName().contains(filter) || employee.getSurname().contains(filter)){
                filtered.add(employee);
            }
        }
        int numberOfPages = filtered.size() / rowsPerPage;
        int rest = filtered.size() % rowsPerPage; // 0, 3, 5
        if(rest > 0) {
            numberOfPages += 1;
        }
        return numberOfPages;
    }

    public List<Employee> search(String searchBy, int page) {
        List<Employee> filtered = new ArrayList<>();
        for(Employee employee: this.employeeList) {
            if(employee.getName().contains(searchBy) || employee.getSurname().contains(searchBy)){
                filtered.add(employee);
            }
        }
        int to = page * rowsPerPage;
        int from = to - rowsPerPage;
        if(to >= filtered.size()){
            to = filtered.size();
        }
        return filtered.subList(from, to);
    }
}
