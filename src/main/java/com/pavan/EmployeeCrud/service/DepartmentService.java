package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.DepartmentResponse;
import com.pavan.EmployeeCrud.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DepartmentService {
    DepartmentResponse addDepartment(Department department);
    List<DepartmentResponse> getDepartments();
}
