package com.example.ERP.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.project.Entity.Companies;

public interface CompanyRepository extends JpaRepository<Companies, Long> {
	
}
