package com.pavan.EmployeeCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ExperienceResponse {
    private int id;
    private String company;
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
