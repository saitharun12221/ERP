package com.example.ERP.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.project.Entity.Companies;
import com.example.ERP.project.Service.CompanyService;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping
	public List<Companies> getAllCompanies() {
		return companyService.getAllCompanies();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Companies> getCompanyById(@PathVariable Long id) {
		Companies company = companyService.getCompanyById(id);
		if (company != null) {
			return ResponseEntity.ok(company);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public Companies createCompany(@RequestBody Companies company) {
		return companyService.createCompany(company);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Companies> updateCompany(@PathVariable Long id, @RequestBody Companies company) {
		Companies updatedCompany = companyService.updateCompany(id, company);
		if (updatedCompany != null) {
			return ResponseEntity.ok(updatedCompany);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
		companyService.deleteCompany(id);
		return ResponseEntity.noContent().build();
	}
}
