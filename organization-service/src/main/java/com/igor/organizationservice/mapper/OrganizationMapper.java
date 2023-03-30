package com.igor.organizationservice.mapper;

import com.igor.organizationservice.dto.OrganizationDto;
import com.igor.organizationservice.entity.Organization;

public class OrganizationMapper {
	public static OrganizationDto dtoFromEntity(Organization organization) {
		OrganizationDto organizationDto = OrganizationDto.builder()
														.id(organization.getId())
														.organizationName(organization.getOrganizationName())
														.organizationDescription(organization.getOrganizationDescription())
														.organizationCode(organization.getOrganizationCode())
														.organizationCreatedDate(organization.getOrganizationCreatedDate())
														.build();
		return organizationDto;
														
	}
	
	public static Organization entityFromDto(OrganizationDto organizationDto) {
		Organization organization = Organization.builder()
														.id(organizationDto.getId())
														.organizationName(organizationDto.getOrganizationName())
														.organizationDescription(organizationDto.getOrganizationDescription())
														.organizationCode(organizationDto.getOrganizationCode())
														.organizationCreatedDate(organizationDto.getOrganizationCreatedDate())
														.build();
		return organization;
														
	}
}
