package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse insertEmployee(EmployeeRequest employee);
    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployee(Integer id);

    EmployeeResponse updateEmployee(EmployeeRequest employee,Integer id);

    void deleteEmployee(Integer id);
}
