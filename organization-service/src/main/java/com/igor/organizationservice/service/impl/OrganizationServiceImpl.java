package com.igor.organizationservice.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.igor.organizationservice.exception.ResourceNotFoundException;
import com.igor.organizationservice.dto.OrganizationDto;
import com.igor.organizationservice.entity.Organization;
import com.igor.organizationservice.mapper.OrganizationMapper;
import com.igor.organizationservice.repository.OrganizationRepository;
import com.igor.organizationservice.service.OrganizationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService{
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		Organization organization = OrganizationMapper.entityFromDto(organizationDto);
		Organization organizationSaved = organizationRepository.save(organization);
		return OrganizationMapper.dtoFromEntity(organizationSaved);
	}

	@Override
	public OrganizationDto findByOrganizationCode(String code) {
		Optional<Organization> optionalOrganization = organizationRepository.findByOrganizationCode(code);
		if(optionalOrganization.isEmpty()) {
			throw new ResourceNotFoundException("department", "code", code);
			
		}
		return OrganizationMapper.dtoFromEntity(optionalOrganization.get());
	}

}
