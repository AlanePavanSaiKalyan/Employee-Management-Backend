package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.DepartmentResponse;
import com.pavan.EmployeeCrud.entity.Department;
import com.pavan.EmployeeCrud.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@CrossOrigin(origins = "http://localhost:5173")
public class DepartmentController {
    private final DepartmentService service;
    public DepartmentController(DepartmentService service){
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<DepartmentResponse> addDepartment(@RequestBody Department department){
        DepartmentResponse response =  service.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public  ResponseEntity<List<DepartmentResponse>> getDepartments(){
        List<DepartmentResponse> response =  service.getDepartments();
        return ResponseEntity.ok(response);
    }
}
