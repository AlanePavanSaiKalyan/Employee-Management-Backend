package com.pavan.EmployeeCrud.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "assets_table")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String assetName;
    @Column(nullable = false,unique = true)
    private String assetCode;
    private String assetSerial;
    private LocalDate assignedDate;
    private LocalDate returnedDate;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetStatus assetStatus;
    @Column(length = 2000)
    private String assetCondition;
    @ManyToOne
    @JoinColumn(name = "employee_id",nullable = false)
    private Employee employee;

}
