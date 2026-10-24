package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.EmployeeEducationRequest;
import com.pavan.EmployeeCrud.dto.EmployeeEducationResponse;
import com.pavan.EmployeeCrud.service.EducationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees/{empId}/education")
@CrossOrigin(origins = "http://localhost:5173")
public class EducationController {
    private final EducationService educationService;
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }
    @PostMapping
    public ResponseEntity<EmployeeEducationResponse> addEducation
            (@PathVariable Integer empId, @RequestBody @Valid EmployeeEducationRequest employeeEducationRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(educationService.saveEducation(employeeEducationRequest,empId));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeEducationResponse>> getEducation(@PathVariable Integer empId){
        return ResponseEntity.ok(educationService.getEducationData(empId));
    }
}
