package com.pavan.EmployeeCrud.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class ExperienceRequest {
    @NotBlank(message = "Comany Name is Mandatory")
    private String company;
    @NotBlank(message = "Designation is Mandatory")
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
