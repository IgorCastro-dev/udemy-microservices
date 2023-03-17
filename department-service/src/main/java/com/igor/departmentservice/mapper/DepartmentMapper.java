package com.igor.departmentservice.mapper;

import com.igor.departmentservice.dto.DepartmentDto;
import com.igor.departmentservice.entity.Department;

public class DepartmentMapper {
	public static Department entityFromDto(DepartmentDto departmentDto) {
		Department department= Department.builder()
				.id(departmentDto.getId())
				.departmentDescription(departmentDto.getDepartmentDescription())
				.departmentName(departmentDto.getDepartmentName())
				.departmentCode(departmentDto.getDepartmentCode())
				.build();
		return department;
	}
	
	public static DepartmentDto dtoFromEntity(Department department) {
		DepartmentDto departmentDto= DepartmentDto.builder()
				.id(department.getId())
				.departmentDescription(department.getDepartmentDescription())
				.departmentName(department.getDepartmentName())
				.departmentCode(department.getDepartmentCode())
				.build();
		return departmentDto;
	}
}
