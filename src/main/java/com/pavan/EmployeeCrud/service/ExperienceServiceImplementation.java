package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.ExperienceRequest;
import com.pavan.EmployeeCrud.dto.ExperienceResponse;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.entity.Experience;
import com.pavan.EmployeeCrud.exception.EmployeeNotFoundException;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;
import com.pavan.EmployeeCrud.repository.ExperienceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImplementation implements ExperienceService{
    private final EmployeeRepo employeeRepo;
    private final ExperienceRepo experienceRepo;

    public ExperienceServiceImplementation(ExperienceRepo experienceRepo,EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
        this.experienceRepo =experienceRepo;
    }
    @Override
    public ExperienceResponse addExperience(ExperienceRequest experienceRequest, Integer empId) {
        Employee employee = employeeRepo.findById(empId).orElseThrow(()->new EmployeeNotFoundException("Employee with id:"+empId+" does not exist in database"));
        Experience experience = Experience.builder()
                .company(experienceRequest.getCompany())
                .designation(experienceRequest.getDesignation())
                .startDate(experienceRequest.getStartDate())
                .endDate(experienceRequest.getEndDate())
                .description(experienceRequest.getDescription())
                .employee(employee).build();
        return mapResponse(experienceRepo.save(experience));
    }

    @Override
    public List<ExperienceResponse> getExperience(Integer empId) {
        if(!employeeRepo.existsById(empId)){
            throw new EmployeeNotFoundException("Employee with id:"+empId+" does not exist!");
        }else{
            return experienceRepo.findByEmployeeId(empId).stream()
                    .map(this::mapResponse).toList();
        }
    }

    public ExperienceResponse mapResponse(Experience experience){
        return new ExperienceResponse(experience.getId(),experience.getCompany(),experience.getDesignation(),experience.getStartDate(),experience.getEndDate(),experience.getDescription());
    }
}
