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
@Table(name = "cash_ledger")
public class Cash {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ledgers_id",columnDefinition = "BIGINT")
	private Ledger ledger;
	private String cash_account_name;
	private String cash_account_code;
	private BigDecimal openingBalance;
	private BigDecimal closingBalance;
	private String currency;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Cash() {
	}
	public Cash(Ledger ledger, String cash_account_name, String cash_account_code, BigDecimal openingBalance, BigDecimal closingBalance, String currency, Timestamp createdAt, Timestamp updatedAt) {
		this.ledger = ledger;
		this.cash_account_name = cash_account_name;
		this.cash_account_code = cash_account_code;
		this.openingBalance = openingBalance;
		this.closingBalance = closingBalance;
		this.currency = currency;
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
		return cash_account_name;
	}
	public void setName(String cash_account_name) {
		this.cash_account_name = cash_account_name;
	}
	public String getCode() {
		return cash_account_code;
	}
	public void setCode(String cash_account_code) {
		this.cash_account_code = cash_account_code;
	}
	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}
	public BigDecimal getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
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
	
