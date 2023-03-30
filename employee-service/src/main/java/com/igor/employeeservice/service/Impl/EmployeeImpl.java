package com.igor.employeeservice.service.Impl;



import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;

import com.igor.employeeservice.dto.ApiResponseDto;
import com.igor.employeeservice.dto.DepartmentDto;
import com.igor.employeeservice.dto.EmployeeDto;
import com.igor.employeeservice.dto.OrganizationDto;
import com.igor.employeeservice.entity.Employee;
import com.igor.employeeservice.exceptions.ResourceNotFoundException;
import com.igor.employeeservice.mapper.EmployeeMapper;
import com.igor.employeeservice.repository.EmployeeRepository;
import com.igor.employeeservice.service.ApiClientDepartment;
import com.igor.employeeservice.service.ApiClientOrganization;
import com.igor.employeeservice.service.EmployeeService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeImpl implements EmployeeService{
	
	private EmployeeRepository employeeRepository;
	private ApiClientDepartment apiClientDepartment;
	private ApiClientOrganization apiClientOrganization;
//	private WebClient webClient;
//	private RestTemplate restTemplate;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		
//		webClient.get()
//		.uri("http://localhost:8081/api/departments/"+employeeDto.getDepartmentCode())
//		.retrieve()
//		.bodyToMono(DepartmentDto.class)
//		.block();
		
		//restTemplate.getForEntity("http://localhost:8081/api/departments/"+employeeDto.getDepartmentCode(),DepartmentDto.class); 
		
		apiClientDepartment.findDepartmentByCode(employeeDto.getDepartmentCode());
		apiClientOrganization.findByOrganizationCode(employeeDto.getOrganizationCode());
		
		
		Employee savedEmployee = employeeRepository.save(EmployeeMapper.entityFromDto(employeeDto));
		
		EmployeeDto savedEmployeeDto = EmployeeMapper.dtoFromEntity(savedEmployee);
		return savedEmployeeDto;
	}

	@CircuitBreaker(name = "${spring.application.name}",fallbackMethod = "getDefaultDepartment")
	@Override
	public ApiResponseDto findById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee","id",employeeId));
		
		EmployeeDto employeeDto = EmployeeMapper.dtoFromEntity(employee);
		
//		DepartmentDto departmentDto = webClient.get()
//				.uri("http://localhost:8081/api/departments/"+employeeDto.getDepartmentCode())
//				.retrieve()
//				.bodyToMono(DepartmentDto.class)
//				.block();		
		
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8081/api/departments/"+employee.getDepartmentCode(),DepartmentDto.class );  
//		DepartmentDto departmentDto = responseEntity.getBody();
		
		
		DepartmentDto departmentDto =  apiClientDepartment.findDepartmentByCode(employeeDto.getDepartmentCode());
		OrganizationDto organizationDto = apiClientOrganization.findByOrganizationCode(employeeDto.getOrganizationCode());
		
		ApiResponseDto apiResponseDto = ApiResponseDto.builder()
													.employeeDto(employeeDto)
													.departmentDto(departmentDto)
													.organizationDto(organizationDto)
													.build();
		
		return apiResponseDto;
	}
	
	public ApiResponseDto getDefaultDepartment(Long employeeId,Exception exception) {
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee","id",employeeId));
		
		EmployeeDto employeeDto = EmployeeMapper.dtoFromEntity(employee);
		
		DepartmentDto departmentDto = DepartmentDto.builder()
										.departmentCode("DF001")
										.departmentName("Default")
										.departmentDescription("department default")
										.build();
		
		System.out.println("departmentdto" + departmentDto);
		
		ApiResponseDto apiResponseDto = ApiResponseDto.builder()
													.employeeDto(employeeDto)
													.departmentDto(departmentDto)
													.build();
		
		return apiResponseDto;
	}
}
