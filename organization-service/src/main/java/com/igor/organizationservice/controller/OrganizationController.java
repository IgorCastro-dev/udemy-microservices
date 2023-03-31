package com.igor.organizationservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.igor.organizationservice.dto.OrganizationDto;
import com.igor.organizationservice.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@Tag(name = "Organization Service - OrganizationController",
	description = "Organization Controller exposes Rest API for Organization Service")
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController{
	
	private OrganizationService organizationService;
	
	@Operation(summary = "save Organization Rest API",
				description = "save Organization Rest API is used to save organization in a database")
	@ApiResponse(responseCode = "201",description = "HTTP Status 201 CREATED")
	@PostMapping
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
		OrganizationDto savedOrganization = organizationService.saveOrganization(organizationDto);
		return new ResponseEntity<>(savedOrganization,HttpStatus.CREATED);
	}
	
	@Operation(summary = "get Organization Rest API",
				description = "get Organization Rest API is used to get Organization object from the database")
	@ApiResponse(responseCode = "200",description = "HTTP Status 200 OK")
	@GetMapping("/{code}")
	public ResponseEntity<OrganizationDto> findByOrganizationCode(@PathVariable("code") String code){
		OrganizationDto organizationDto = organizationService.findByOrganizationCode(code);
		return new ResponseEntity<>(organizationDto,HttpStatus.OK);
	}
}
