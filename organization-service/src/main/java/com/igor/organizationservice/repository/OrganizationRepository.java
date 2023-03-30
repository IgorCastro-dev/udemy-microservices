package com.igor.organizationservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{
	Optional<Organization> findByOrganizationCode(String code);
}
