package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.EmployeeEducationRequest;
import com.pavan.EmployeeCrud.dto.EmployeeEducationResponse;

import java.util.List;

public interface EducationService {
    EmployeeEducationResponse saveEducation(EmployeeEducationRequest request,Integer id);
    List<EmployeeEducationResponse> getEducationData(Integer empId);
}
