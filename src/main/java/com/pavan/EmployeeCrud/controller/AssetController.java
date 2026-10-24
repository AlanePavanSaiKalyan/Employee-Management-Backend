package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.AssetRequest;
import com.pavan.EmployeeCrud.dto.AssetResponse;
import com.pavan.EmployeeCrud.service.AssetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/employees/{empId}/assets")
public class AssetController {
    private AssetService service;
    public AssetController(AssetService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<AssetResponse> addAsset(@PathVariable Integer empId, @RequestBody @Valid AssetRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAsset(empId,request));
    }

    @GetMapping
    public ResponseEntity<List<AssetResponse>> getAssets(@PathVariable Integer empId){
        return ResponseEntity.ok(service.getAssets(empId));
    }
}
