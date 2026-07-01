package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Income;
import com.example.ERP.project.Repository.IncomeRepository;

@Service

public class IncomeService {
	@Autowired
	private IncomeRepository incomeRepository;
	public List<Income> getAllIncome() {
		return incomeRepository.findAll();
	}
	public Income getIncomeById(Long id) {
		return incomeRepository.findById(id).orElse(null);
	}
	public Income createIncome(Income income) {
		return incomeRepository.save(income);
	}
	public Income updateIncome(Long id, Income income) {
		Income existingIncome = incomeRepository.findById(id).orElse(null);
		if (existingIncome != null) {
			existingIncome.setLedger(income.getLedger());
			existingIncome.setName(income.getName());
			existingIncome.setCode(income.getCode());
			existingIncome.setCategory(income.getCategory());
			existingIncome.setSubCategory(income.getSubCategory());
			existingIncome.setTaxable(income.isTaxable());
			existingIncome.setTaxRate(income.getTaxRate());
			existingIncome.setCreatedAt(income.getCreatedAt());
			existingIncome.setUpdatedAt(income.getUpdatedAt());
			return incomeRepository.save(existingIncome);
		}
		return null;
	}
	public void deleteIncome(Long id) {
		incomeRepository.deleteById(id);
	}
	
}
