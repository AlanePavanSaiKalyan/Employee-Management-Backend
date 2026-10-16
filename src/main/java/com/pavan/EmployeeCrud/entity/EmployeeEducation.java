package com.pavan.EmployeeCrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_education")
public class EmployeeEducation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String degree;
    private String fieldStudy;
    private String institution;
    private String university;
    private Integer startYear;
    private Integer endYear;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;
}
