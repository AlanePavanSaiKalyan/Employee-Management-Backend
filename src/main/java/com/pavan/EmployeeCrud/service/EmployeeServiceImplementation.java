package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    public EmployeeServiceImplementation(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }
    @Override
    public EmployeeResponse insertEmployee(EmployeeRequest employee) {

        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(employee.getDepartment());
        emp.setSalary(employee.getSalary());
        Employee response = employeeRepo.save(emp);
        return new EmployeeResponse(response.getId(),response.getName(),response.getEmail(),response.getDepartment(),response.getSalary());
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee getEmployee(Integer id) {
       return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee,Integer id) {
        Employee emp = employeeRepo.findById(id).orElse(null);
        if(emp !=null){
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setSalary(employee.getSalary());
            emp.setDepartment(employee.getDepartment());
            return employeeRepo.save(emp);
        }else{
            return null;
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        return ;
    }
}
