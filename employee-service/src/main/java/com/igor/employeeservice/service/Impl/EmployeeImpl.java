package com.igor.employeeservice.service.Impl;

import org.springframework.stereotype.Service;

import com.igor.employeeservice.dto.EmployeeDto;
import com.igor.employeeservice.entity.Employee;
import com.igor.employeeservice.exceptions.ResourceNotFoundException;
import com.igor.employeeservice.mapper.EmployeeMapper;
import com.igor.employeeservice.repository.EmployeeRepository;
import com.igor.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee savedEmployee = employeeRepository.save(EmployeeMapper.entityFromDto(employeeDto));
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.dtoFromEntity(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto findById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee","id",employeeId));
		EmployeeDto employeeDto = EmployeeMapper.dtoFromEntity(employee);
		return employeeDto;
	}

}
