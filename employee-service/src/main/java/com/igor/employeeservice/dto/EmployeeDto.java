package com.igor.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String departmentCode;
	private String organizationCode;
}
