package com.pavan.EmployeeCrud.repository;

import com.pavan.EmployeeCrud.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssetRepo extends JpaRepository<Asset,Integer> {
    List<Asset> findByEmployeeId(Integer empId);
}
