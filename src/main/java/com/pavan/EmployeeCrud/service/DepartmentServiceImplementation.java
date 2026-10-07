package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.DepartmentResponse;
import com.pavan.EmployeeCrud.entity.Department;
import com.pavan.EmployeeCrud.repository.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService{
    private final DepartmentRepo departmentRepo;

    public DepartmentServiceImplementation(DepartmentRepo departmentRepo){
        this.departmentRepo = departmentRepo;
    }
    @Override
    public DepartmentResponse addDepartment(Department department) {
       Department dept = departmentRepo.save(department);
       return new DepartmentResponse(dept.getId(),dept.getName());
    }

    @Override
    public List<DepartmentResponse> getDepartments() {
        return departmentRepo.findAll().stream().map((dep)->new DepartmentResponse(dep.getId(),dep.getName())).toList();
    }
}
