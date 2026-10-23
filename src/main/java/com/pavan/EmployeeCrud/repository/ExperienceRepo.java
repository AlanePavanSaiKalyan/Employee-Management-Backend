package com.pavan.EmployeeCrud.repository;

import com.pavan.EmployeeCrud.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepo extends JpaRepository<Experience, Integer> {
    List<Experience> findByEmployeeId(Integer empId);
}
