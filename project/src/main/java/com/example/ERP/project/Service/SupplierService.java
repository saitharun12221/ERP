package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Supplier;
import com.example.ERP.project.Repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}
	public Supplier getSupplierById(Long id) {
		return supplierRepository.findById(id).orElse(null);
	}
	public Supplier createSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	public Supplier updateSupplier(Long id, Supplier supplier) {
		Supplier existingSupplier = supplierRepository.findById(id).orElse(null);
		if (existingSupplier != null) {
			existingSupplier.setLedger(supplier.getLedger());
			existingSupplier.setSupplier_code(supplier.getSupplier_code());
			existingSupplier.setSupplier_name(supplier.getSupplier_name());
			existingSupplier.setEmail(supplier.getEmail());
			existingSupplier.setGstNumber(supplier.getGstNumber());
			existingSupplier.setPhone(supplier.getPhone());
			existingSupplier.setAddress(supplier.getAddress());
			existingSupplier.setCredit_period(supplier.getCredit_period());
			existingSupplier.setPan_number(supplier.getPan_number());
			return supplierRepository.save(existingSupplier);
		}
		return null;
	}
	public boolean deleteSupplier(Long id) {
		Supplier existingSupplier = supplierRepository.findById(id).orElse(null);
		if (existingSupplier != null) {
			supplierRepository.delete(existingSupplier);
			return true;
		}
		return false;
	}
}
