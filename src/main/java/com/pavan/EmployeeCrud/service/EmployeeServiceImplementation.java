package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.DepartmentResponse;
import com.pavan.EmployeeCrud.dto.EmployeeRequest;
import com.pavan.EmployeeCrud.dto.EmployeeResponse;
import com.pavan.EmployeeCrud.entity.Department;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.exception.EmployeeNotFoundException;
import com.pavan.EmployeeCrud.repository.DepartmentRepo;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final DepartmentRepo departmentRepo;
    public EmployeeServiceImplementation(EmployeeRepo employeeRepo, DepartmentRepo departmentRepo){
        this.employeeRepo = employeeRepo;
        this.departmentRepo =departmentRepo;

    }
    @Override
    public EmployeeResponse insertEmployee(EmployeeRequest employee) {
        Department department = departmentRepo.findById(employee.getDepartmentId()).orElseThrow(()->new RuntimeException("Department not found"));
        Employee emp = new Employee();
        emp.setName(employee.getName());
        emp.setEmail(employee.getEmail());
        emp.setDepartment(department);
        emp.setDesignation(employee.getDesignation());
        emp.setSalary(employee.getSalary());
        Employee response = employeeRepo.save(emp);
        return new EmployeeResponse(response.getId(),response.getName(),response.getEmail(),mapDepartment(response.getDepartment()),response.getDesignation(),response.getSalary());
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        return employeeRepo.findAll().stream().map(emp->new EmployeeResponse(emp.getId(), emp.getName(),emp.getEmail() ,mapDepartment(emp.getDepartment()),emp.getDesignation(),emp.getSalary())).toList();
    }

    @Override
    public EmployeeResponse getEmployee(Integer id) {
       Employee employee= employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id " + id + " not found"));
       return new EmployeeResponse(employee.getId(), employee.getName(),  employee.getEmail(),mapDepartment(employee.getDepartment()),employee.getDesignation(),employee.getSalary() );
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employee,Integer id) {
        Department department = departmentRepo.findById(employee.getDepartmentId()).orElseThrow(()->new RuntimeException("Department not found"));
        Employee emp = employeeRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException("Employee with id:"+id+" doesn't exist in the database"));
        if(emp !=null){
            emp.setName(employee.getName());
            emp.setEmail(employee.getEmail());
            emp.setSalary(employee.getSalary());
            emp.setDepartment(department);
            Employee employee1 =employeeRepo.save(emp);
            return new EmployeeResponse(employee1.getId(),employee1.getName(),employee1.getEmail(),mapDepartment(employee1.getDepartment()),employee1.getDesignation(),employee1.getSalary());
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

    private DepartmentResponse mapDepartment(Department department) {

        return new DepartmentResponse(
                department.getId(),
                department.getName()
        );
    }
}
