package com.igor.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.igor.employeeservice.dto.OrganizationDto;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface ApiClientOrganization {	
	@GetMapping("api/organizations/{code}")
	OrganizationDto findByOrganizationCode(@PathVariable("code") String code);
}
