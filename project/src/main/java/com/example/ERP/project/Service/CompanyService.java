package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Companies;
import com.example.ERP.project.Repository.CompanyRepository;

@Service
public class CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	public List<Companies> getAllCompanies() {
		return companyRepository.findAll();
	}

	public Companies getCompanyById(long id) {
		return companyRepository.findById(id).orElse(null);
	}

	public Companies createCompany(Companies company) {
		return companyRepository.save(company);
	}

	public Companies updateCompany(long id, Companies updatedCompany) {
		Companies existingCompany = companyRepository.findById(id).orElse(null);
		if (existingCompany != null) {
			existingCompany.setCompany_name(updatedCompany.getCompany_name());
			existingCompany.setIndustry(updatedCompany.getIndustry());
			existingCompany.setWebSite(updatedCompany.getWebSite());
			existingCompany.setEmail(updatedCompany.getEmail());
			existingCompany.setGstNumber(updatedCompany.getGstNumber());
			existingCompany.setPhone(updatedCompany.getPhone());
			existingCompany.setAddress(updatedCompany.getAddress());
			existingCompany.setCity(updatedCompany.getCity());
			existingCompany.setState(updatedCompany.getState());
			existingCompany.setCountry(updatedCompany.getCountry());
			return companyRepository.save(existingCompany);
		}
		return null;
	}

	public void deleteCompany(long id) {
		companyRepository.deleteById(id);
	}
}
