package com.igor.departmentservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.departmentservice.dto.DepartmentDto;
import com.igor.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController{
	
	private DepartmentService departmentService;
	
	@PostMapping
	private ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);		
	}
	
	@GetMapping("/{code}")
	private ResponseEntity<DepartmentDto> findDepartmentByCode(@PathVariable("code") String departmentCode){
		DepartmentDto departmentDto = departmentService.findByDepartmentCode(departmentCode);
		return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
}
