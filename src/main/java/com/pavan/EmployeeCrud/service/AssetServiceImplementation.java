package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.AssetRequest;
import com.pavan.EmployeeCrud.dto.AssetResponse;
import com.pavan.EmployeeCrud.entity.Asset;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.exception.EmployeeNotFoundException;
import com.pavan.EmployeeCrud.repository.AssetRepo;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AssetServiceImplementation implements AssetService{
    private final EmployeeRepo employeeRepo;
    private final AssetRepo assetRepo;

    public AssetServiceImplementation(AssetRepo assetRepo,EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
        this.assetRepo  = assetRepo;
    }
    @Override
    public AssetResponse addAsset(Integer empId, AssetRequest assetRequest) {
        Employee employee = employeeRepo.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee with id:"+empId+" doesn't exist"));
        Asset asset = Asset.builder().assetName(assetRequest.getAssetName())
                .assetCode(assetRequest.getAssetCode())
                .assetCondition(assetRequest.getAssetCondition())
                .assignedDate(assetRequest.getAssignedDate())
                .assetSerial(assetRequest.getAssetSerial())
                .returnedDate(assetRequest.getReturnedDate())
                .assetStatus(assetRequest.getAssetStatus())
                .employee(employee)
                .build();
        return mapToResponse(assetRepo.save(asset));
    }

    @Override
    public List<AssetResponse> getAssets(Integer empId) {
        if(employeeRepo.existsById(empId)){
            return assetRepo.findByEmployeeId(empId).stream()
                    .map(this::mapToResponse).toList();
        }
        else throw  new EmployeeNotFoundException("Employee with id:"+empId+" does not exists!");
    }

    public AssetResponse mapToResponse(Asset asset){
        return new AssetResponse(asset.getId(),asset.getAssetName(),asset.getAssetCode()
                ,asset.getAssetSerial(),asset.getAssignedDate(),asset.getReturnedDate()
                ,asset.getAssetStatus(),asset.getAssetCondition());
    }
}
