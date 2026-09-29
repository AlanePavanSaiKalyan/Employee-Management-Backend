package com.pavan.EmployeeCrud.repository;

import com.pavan.EmployeeCrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
}
