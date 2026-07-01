package com.example.ERP.project.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "income_ledger")
public class Income {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ledgers_id")
	private Ledger ledger;
	private String name;
	private String code;
	private String category;
	private String subCategory;
	private boolean isTaxable;
	private BigDecimal TaxRate;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Income() {
	}
	public Income(Ledger ledger, String name, String code, String category, String subCategory, boolean isTaxable, BigDecimal TaxRate, Timestamp createdAt, Timestamp updatedAt) {
		this.ledger = ledger;
		this.name = name;
		this.code = code;
		this.category = category;
		this.subCategory = subCategory;
		this.isTaxable = isTaxable;
		this.TaxRate = TaxRate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Ledger getLedger() {
		return ledger;
	}
	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}
	public boolean isTaxable() {
		return isTaxable;
	}
	public void setTaxable(boolean isTaxable) {
		this.isTaxable = isTaxable;
	}
	public BigDecimal getTaxRate() {
		return TaxRate;
	}
	public void setTaxRate(BigDecimal taxRate) {
		TaxRate = taxRate;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}
	
}
