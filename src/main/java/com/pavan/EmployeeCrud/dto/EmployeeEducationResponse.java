package com.pavan.EmployeeCrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeEducationResponse {
        private Integer id;
        private String degree;
        private String fieldOfStudy;
        private String institution;
        private String university;
        private Integer startYear;
        private Integer endYear;
}
