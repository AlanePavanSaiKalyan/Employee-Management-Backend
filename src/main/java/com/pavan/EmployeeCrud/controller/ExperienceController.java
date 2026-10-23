package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.ExperienceRequest;
import com.pavan.EmployeeCrud.dto.ExperienceResponse;
import com.pavan.EmployeeCrud.service.ExperienceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/employees/{empId}/experience")
@CrossOrigin(origins = "http://localhost:5173")
public class ExperienceController {
    private final ExperienceService experienceService;


    public ExperienceController(ExperienceService experienceService){
        this.experienceService=experienceService;
    }
    @PostMapping
    public ResponseEntity<ExperienceResponse> addExperience(@PathVariable Integer empId, @RequestBody @Valid ExperienceRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(experienceService.addExperience(request,empId));
    }

    @GetMapping
    public ResponseEntity<List<ExperienceResponse>> getExperience(@PathVariable Integer empId){
        return ResponseEntity.ok(experienceService.getExperience(empId));
    }
}
