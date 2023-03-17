package com.igor.departmentservice.service.Impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.igor.departmentservice.dto.DepartmentDto;
import com.igor.departmentservice.entity.Department;
import com.igor.departmentservice.exceptions.ResourceNotFoundException;
import com.igor.departmentservice.repository.DepartmentRepository;
import com.igor.departmentservice.service.DepartmentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentImpl implements DepartmentService{
	
	private DepartmentRepository departmentRepository;
	private ModelMapper modelMapper;

	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		//DepartmentMapper.entityFromDto(departmentDto)
		Department savedDepartment = departmentRepository.save(modelMapper.map(departmentDto,Department.class));		
		DepartmentDto savedDepartmentDto= modelMapper.map(savedDepartment, DepartmentDto.class);			
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto findByDepartmentCode(String departmentCode) {
		Optional<Department>  optionalDepartment = departmentRepository.findByDepartmentCode(departmentCode);
		if(optionalDepartment.isEmpty()) {
			throw new ResourceNotFoundException("department", "code", departmentCode);
		}
		Department department = optionalDepartment.get();
		DepartmentDto departmentDto = modelMapper.map(department,DepartmentDto.class);
		return departmentDto;
	}
	
}
