package com.step.model;


import com.step.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDAO {

    public long countAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Long> query = session.createQuery("SELECT count(*) FROM Employee", Long.class);
        Long count = query.getSingleResult();
        tx.commit();
        session.close();
        return count;
    }

    public long countAll(String filter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Long> query = session.createQuery("SELECT count(*) FROM Employee where name like :name", Long.class);
        query.setParameter("name", '%' + filter + '%');
        Long count = query.getSingleResult();
        tx.commit();
        session.close();
        return count;
    }

    public List<Employee> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = query.list();
        tx.commit();
        session.close();
        return employees;
    }


    public List<Employee> findPage(int page, int rowsPerPage) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
        query.setFirstResult((page - 1) * rowsPerPage);
        query.setMaxResults(page * rowsPerPage);
        List<Employee> employees = query.list();
        tx.commit();
        session.close();
        return employees;
    }

    public List<Employee> findPage(int page, int rowsPerPage, String filter) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Employee> query = session.createQuery("FROM Employee where name like :name", Employee.class);
        query.setParameter("name", '%' + filter + '%');
        query.setFirstResult((page - 1) * rowsPerPage);
        query.setMaxResults(page * rowsPerPage);
        List<Employee> employees = query.list();
        tx.commit();
        session.close();
        return employees;
    }

    public Employee findById(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        tx.commit();
        session.close();
        return employee;
    }

    public List<Employee> findByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query<Employee> query = session.createQuery("FROM Employee WHERE name = :name", Employee.class);
        query.setParameter("name", name);
        List<Employee> employees = query.list();
        tx.commit();
        session.close();
        return employees;
    }

    public void create(String name, String surname, LocalDate birthdate) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee emp = new Employee(name, surname, birthdate);
        session.save(emp);
        tx.commit();
        session.close();
    }


    public void create(Employee employee) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employee);
        tx.commit();
        session.close();
    }

    public void create(List<Employee> employees) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        for (int index = 0; index < employees.size(); index++) {
            session.save(employees.get(index));
            if (index % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        tx.commit();
        session.close();
    }

    public Employee update(Integer id, String name, String surname, LocalDate birthdate) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        employee.setName(name);
        employee.setSurname(surname);
        employee.setBirthdate(birthdate);
        session.update(employee);
        tx.commit();
        session.close();
        return employee;
    }

    public Employee delete(Integer id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, id);
        session.delete(employee);
        tx.commit();
        session.close();
        return employee;
    }
}
