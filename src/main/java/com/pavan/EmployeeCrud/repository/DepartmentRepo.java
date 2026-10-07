package com.pavan.EmployeeCrud.repository;

import com.pavan.EmployeeCrud.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}
