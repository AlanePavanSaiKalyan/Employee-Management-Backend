package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    private final EmployeeService service;

    public  EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponse> createEmployee(@Valid @RequestBody EmployeeRequest request){
        EmployeeResponse response = service.insertEmployee(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponse> getEmployee(@PathVariable Integer id){
        EmployeeResponse employee= service.getEmployee(id);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@RequestBody EmployeeRequest employee,@PathVariable Integer id){
        EmployeeResponse emp = service.updateEmployee(employee,id);
        return ResponseEntity.ok(emp);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponse> > getAllEmployees(){
        List<EmployeeResponse> employees=  service.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Integer id){
         service.deleteEmployee(id);
         return ResponseEntity.noContent().build();
    }
}
