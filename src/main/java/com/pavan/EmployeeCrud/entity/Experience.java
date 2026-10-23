package com.pavan.EmployeeCrud.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "employee_experience")
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String company;
    @Column(nullable = false)
    private String designation;
    private LocalDate startDate;
    private LocalDate endDate;
    @Column(length = 2000)
    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;


}
