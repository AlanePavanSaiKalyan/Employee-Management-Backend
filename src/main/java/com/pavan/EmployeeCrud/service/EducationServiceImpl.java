package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeEducationRequest;
import com.pavan.EmployeeCrud.dto.EmployeeEducationResponse;
import com.pavan.EmployeeCrud.entity.Employee;
import com.pavan.EmployeeCrud.entity.EmployeeEducation;
import com.pavan.EmployeeCrud.exception.EmployeeNotFoundException;
import com.pavan.EmployeeCrud.repository.EducationRepo;
import com.pavan.EmployeeCrud.repository.EmployeeRepo;

import java.util.List;

public class EducationServiceImpl implements EducationService{
    private final EmployeeRepo employeeRepo;
    private final EducationRepo educationRepo;

    public EducationServiceImpl(EducationRepo educationRepo,EmployeeRepo employeeRepo){
        this.educationRepo = educationRepo;
        this.employeeRepo = employeeRepo;
    }
    @Override
    public EmployeeEducationResponse saveEducation(EmployeeEducationRequest request, Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id:"+id+" does not exists"));
        EmployeeEducation education = EmployeeEducation.builder().degree(request.getDegree())
                .university(request.getUniversity())
                .institution(request.getInstitution())
                .startYear(request.getStartYear())
                .endYear(request.getEndYear())
                .employee(employee).build();
        EmployeeEducation employeeEducation = educationRepo.save(education);
        return mapResponse(employeeEducation);
    }

    @Override
    public List<EmployeeEducationResponse> getEducationData(Integer empId) {
        if(!employeeRepo.existsById(empId)){
            throw new EmployeeNotFoundException("Employee with id:"+empId+" does not exist in database");
        }
            return educationRepo.findByEmployeeId(empId).stream()
                    .map(this::mapResponse).toList();

    }

    public EmployeeEducationResponse mapResponse(EmployeeEducation education){
        return new EmployeeEducationResponse(education.getId(),education.getDegree(),education.getFieldStudy(),education.getInstitution(),education.getUniversity(),education.getStartYear(),education.getEndYear());
    }
}
