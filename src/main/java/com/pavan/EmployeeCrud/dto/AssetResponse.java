package com.pavan.EmployeeCrud.dto;

import com.pavan.EmployeeCrud.entity.AssetStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
@Data
@AllArgsConstructor
public class AssetResponse {
    private Integer id;
    private String assetName;
    private String assetCode;
    private String assetSerial;
    private LocalDate assignedDate;
    private LocalDate returnedDate;
    private AssetStatus assetStatus;
    private String assetCondition;
}
