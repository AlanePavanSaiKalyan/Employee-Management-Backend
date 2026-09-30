package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.exception.EmployeeNotFoundException;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepo.findAll().stream().map(emp->new EmployeeResponse(emp.getId(), emp.getName(),emp.getEmail() ,emp.getDepartment(),emp.getSalary())).toList();
    }

    @Override
    public EmployeeResponse getEmployee(Integer id) {
       Employee employee= employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id " + id + " not found"));
       return new EmployeeResponse(employee.getId(), employee.getName(),  employee.getEmail(),employee.getDepartment(),employee.getSalary() );
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employee,Integer id) {
        Employee emp = employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee with id:"+id+" doesn't exist in the database"));
        if(emp !=null){
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setSalary(employee.getSalary());
            emp.setDepartment(employee.getDepartment());
            Employee employee1 =employeeRepo.save(emp);
            return new EmployeeResponse(employee1.getId(),employee1.getName(),employee1.getEmail(),employee1.getDepartment(),employee1.getSalary());
        }else{
            return null;
        }
    }

    @Override
    public void deleteEmployee(Integer id) {
        if(!employeeRepo.existsById(id)) {
            throw new EmployeeNotFoundException("Employee with id:"+id+" doesn't exist in the database");
        }
        else employeeRepo.deleteById(id);
    }
}
