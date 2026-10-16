package com.pavan.EmployeeCrud.repository;

import com.pavan.EmployeeCrud.entity.EmployeeEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepo extends JpaRepository<EmployeeEducation,Integer> {
    List<EmployeeEducation> findByEmployeeId(Integer employeeId);
}
