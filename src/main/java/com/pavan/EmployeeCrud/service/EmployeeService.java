package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse insertEmployee(EmployeeRequest employee);
    List<Employee> getAllEmployees();

    Employee getEmployee(Integer id);

    Employee updateEmployee(Employee employee,Integer id);

    void deleteEmployee(Integer id);
}
