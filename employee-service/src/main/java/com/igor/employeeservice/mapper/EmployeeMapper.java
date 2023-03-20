package com.igor.employeeservice.mapper;

import com.igor.employeeservice.dto.EmployeeDto;
import com.igor.employeeservice.entity.Employee;

public class EmployeeMapper {
	public static Employee entityFromDto(EmployeeDto employeeDto) {
		Employee employee = Employee.builder()
							.id(employeeDto.getId())
							.firstName(employeeDto.getFirstName())
							.lastName(employeeDto.getLastName())
							.email(employeeDto.getEmail())
							.departmentCode(employeeDto.getDepartmentCode())
							.build();
		return employee;
		}
	
	public static EmployeeDto dtoFromEntity(Employee employee) {
		EmployeeDto employeedto = EmployeeDto.builder()
							.id(employee.getId())
							.firstName(employee.getFirstName())
							.lastName(employee.getLastName())
							.email(employee.getEmail())
							.departmentCode(employee.getDepartmentCode())
							.build();
		return employeedto;
		}
}
