package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee insertEmployee(Employee employee);
    List<Employee> getAllEmployees();

    Employee getEmployee(Integer id);

    Employee updateEmployee(Employee employee,Integer id);

    void deleteEmployee(Integer id);
}
