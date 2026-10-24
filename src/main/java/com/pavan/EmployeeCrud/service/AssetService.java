package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.AssetRequest;
import com.pavan.EmployeeCrud.dto.AssetResponse;

import java.util.List;

public interface AssetService {
    AssetResponse addAsset(Integer empId, AssetRequest assetRequest);
    List<AssetResponse> getAssets(Integer empId);
}
