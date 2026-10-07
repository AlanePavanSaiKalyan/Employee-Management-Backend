package com.pavan.EmployeeCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponse {
    private Integer id;
    private String name;
    private String email;
    private DepartmentResponse department;
    private String designation;
    private BigDecimal salary;
}
