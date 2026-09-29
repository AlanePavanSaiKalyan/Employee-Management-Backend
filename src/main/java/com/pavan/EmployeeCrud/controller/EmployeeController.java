package com.pavan.EmployeeCrud.controller;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    public  EmployeeController(EmployeeService service){
        this.service = service;
    }

    @PostMapping
    public EmployeeResponse createEmployee( @Valid @RequestBody EmployeeRequest request){
        return service.insertEmployee(request);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Integer id){
        return service.getEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@RequestBody Employee employee,@PathVariable Integer id){
        return service.updateEmployee(employee,id);
    }

    @GetMapping
    public List<Employee> getAllEmployees(){
        return service.getAllEmployees();
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Integer id){
         service.deleteEmployee(id);
    }
}
