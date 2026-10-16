package com.pavan.EmployeeCrud.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeEducationRequest {
    @NotBlank(message = "Degree is required")
    private String degree;
    private String fieldOfStudy;
    @NotBlank(message = "Institution is required")
    private String institution;
    private String university;
    @NotNull(message = "Start year is required")
    private Integer startYear;
    private Integer endYear;
}