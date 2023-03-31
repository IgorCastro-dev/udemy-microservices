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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Department Service - DepartmentController",
	description = "Department Controller Exposes Rest API for Department-Service")
@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController{
	
	private DepartmentService departmentService;
	
	@Operation(summary = "save Department Rest API",
				description = "save Department Rest API is used to save department in a database")
	@ApiResponse(responseCode = "201",description = "HTTP 201 Status CREATED")
	@PostMapping
	private ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment,HttpStatus.CREATED);		
	}
	
	@Operation(summary = "Get Department Rest API",
			description = "Get Department Rest API is used to get department object from the database")
	@ApiResponse(responseCode = "200",description = "HTTP 200 Status OK")
	@GetMapping("/{code}")
	private ResponseEntity<DepartmentDto> findDepartmentByCode(@PathVariable("code") String departmentCode){
		DepartmentDto departmentDto = departmentService.findByDepartmentCode(departmentCode);
		return  new ResponseEntity<>(departmentDto,HttpStatus.OK);
	}
}
