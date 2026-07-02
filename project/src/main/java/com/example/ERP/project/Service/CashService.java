package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Cash;
import com.example.ERP.project.Repository.CashRepository;

@Service

public class CashService {
	@Autowired
	private CashRepository cashRepository;
	public List<Cash> getAllCash() {
		return cashRepository.findAll();
	}
	public Cash getCashById(Long id) {
		return cashRepository.findById(id).orElse(null);
	}
	public Cash getCashByLedgerId(Long ledgerId) {
	    return cashRepository.findByLedgerId(ledgerId).orElse(null);
	}
	public Cash createCash(Cash cash) {
		return cashRepository.save(cash);
	}
	public Cash updateCash(Long id, Cash cash) {
		Cash existingCash = cashRepository.findById(id).orElse(null);
		if (existingCash != null) {
			existingCash.setLedger(cash.getLedger());
			existingCash.setName(cash.getName());
			existingCash.setCode(cash.getCode());
			existingCash.setOpeningBalance(cash.getOpeningBalance());
			existingCash.setClosingBalance(cash.getClosingBalance());
			existingCash.setCurrency(cash.getCurrency());
			existingCash.setCreatedAt(cash.getCreatedAt());
			existingCash.setUpdatedAt(cash.getUpdatedAt());
			return cashRepository.save(existingCash);
		}
		return null;
	}
	public void deleteCash(Long id) {
		cashRepository.deleteById(id);
	}
}
