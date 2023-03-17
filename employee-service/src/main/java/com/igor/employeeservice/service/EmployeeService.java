package com.igor.employeeservice.service;

import com.igor.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	EmployeeDto findById(Long employeeId);
}
