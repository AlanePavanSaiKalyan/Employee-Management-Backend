package com.pavan.EmployeeCrud.service;

import com.pavan.EmployeeCrud.dto.ExperienceRequest;
import com.pavan.EmployeeCrud.dto.ExperienceResponse;

import java.util.List;

public interface ExperienceService {
    ExperienceResponse addExperience(ExperienceRequest experienceRequest,Integer empId);
    List<ExperienceResponse> getExperience(Integer empId);
}
