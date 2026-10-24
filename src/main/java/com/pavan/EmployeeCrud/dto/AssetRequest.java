package com.pavan.EmployeeCrud.dto;

import com.pavan.EmployeeCrud.entity.AssetStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AssetRequest {
    @NotBlank(message = "Asset Name Is Mandatory")
    private String assetName;
    @NotBlank(message = "Asset Code Is Mandatory")
    private String assetCode;
    private String assetSerial;
    @NotNull(message = "Assigned Date Is Mandatory")
    private LocalDate assignedDate;
    private LocalDate returnedDate;
    @NotNull(message = "Status Is Mandatory")
    private AssetStatus assetStatus;
    private String assetCondition;
}
