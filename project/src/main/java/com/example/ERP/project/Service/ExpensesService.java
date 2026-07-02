package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Expenses;
import com.example.ERP.project.Repository.ExpensesRepository;

@Service

public class ExpensesService {
	@Autowired
	private ExpensesRepository expensesRepository;
	public List<Expenses> getAllExpenses() {
		return expensesRepository.findAll();
	}
	public Expenses getExpensesById(Long id) {
		return expensesRepository.findById(id).orElse(null);
	}
	public Expenses getExpensesByLedgerId(Long ledgerId) {
	    return expensesRepository.findByLedgerId(ledgerId).orElse(null);
	}
	public Expenses createExpenses(Expenses expenses) {
		return expensesRepository.save(expenses);
	}
	public Expenses updateExpenses(Long id, Expenses expenses) {
		Expenses existingExpenses = expensesRepository.findById(id).orElse(null);
		if (existingExpenses != null) {
			existingExpenses.setLedger(expenses.getLedger());
			existingExpenses.setCode(expenses.getCode());
			existingExpenses.setCategory(expenses.getCategory());
			existingExpenses.setSubCategory(expenses.getSubCategory());
			existingExpenses.setTaxable(expenses.isTaxable());
			existingExpenses.setTaxRate(expenses.getTaxRate());
			existingExpenses.setCreatedAt(expenses.getCreatedAt());
			existingExpenses.setUpdatedAt(expenses.getUpdatedAt());
			return expensesRepository.save(existingExpenses);
		}
		return null;
	}
	public void deleteExpenses(Long id) {
		expensesRepository.deleteById(id);
	}
}
