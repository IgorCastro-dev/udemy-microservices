package com.igor.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.igor.employeeservice.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClientDepartment {
	@GetMapping("api/departments/{code}")
	DepartmentDto findDepartmentByCode(@PathVariable("code") String departmentCode);
	
}
