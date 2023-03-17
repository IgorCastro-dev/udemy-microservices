package com.igor.departmentservice.service;

import com.igor.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	DepartmentDto findByDepartmentCode(String departmentCode);
}
