package com.igor.organizationservice.service;

import com.igor.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	OrganizationDto findByOrganizationCode(String code);
}
