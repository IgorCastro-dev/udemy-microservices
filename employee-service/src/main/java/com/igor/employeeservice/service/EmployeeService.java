package com.igor.employeeservice.service;

import com.igor.employeeservice.dto.ApiResponseDto;
import com.igor.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	ApiResponseDto findById(Long employeeId);
}
