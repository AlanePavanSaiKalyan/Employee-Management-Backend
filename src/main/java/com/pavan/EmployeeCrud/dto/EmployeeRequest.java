package com.pavan.EmployeeCrud.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @Email(message = "Email is invalid")
    @NotBlank(message = "Email is required")
    private String email;
    @NotNull(message = "Department is required")
    private Integer departmentId;
    @NotBlank(message = "Designation is required")
    private String designation;
    @NotNull(message = "Salary is required")
    @DecimalMin(value = "0.0",inclusive = false,message = "Salary must be greater than 0")
    @Positive(message = "Salary should be greater than 0")
    private BigDecimal salary;
}
