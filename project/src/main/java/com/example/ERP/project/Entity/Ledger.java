package com.example.ERP.project.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.example.ERP.project.Enum.Ledger_category_enum;
import com.example.ERP.project.Enum.Ledger_enum;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ledgers")
public class Ledger {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String ledger_name;
	private String ledger_code;
	private Ledger_enum ledger_enum;
	private Ledger_category_enum ledger_category_enum;
	private BigDecimal opening_balance;
	private BigDecimal closing_balance;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "companies_id")
	private Companies company;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Ledger() {
		super();
	}
	public Ledger(long id, String ledger_name, String ledger_code, Ledger_enum ledger_enum, Ledger_category_enum ledger_category_enum,
			BigDecimal opening_balance, BigDecimal closing_balance, Companies company,Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.ledger_name = ledger_name;
		this.ledger_code = ledger_code;
		this.ledger_enum = ledger_enum;
		this.ledger_category_enum = ledger_category_enum;
		this.opening_balance = opening_balance;
		this.closing_balance = closing_balance;
		this.company = company;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLedger_name() {
		return ledger_name;
	}
	public void setLedger_name(String ledger_name) {
		this.ledger_name = ledger_name;
	}
	public String getLedger_code() {
		return ledger_code;
	}
	public void setLedger_code(String ledger_code) {
		this.ledger_code = ledger_code;
	}
	public Ledger_enum getLedger_enum() {
		return ledger_enum;
	}
	public void setLedger_enum(Ledger_enum ledger_enum) {
		this.ledger_enum = ledger_enum;
	}
	public Ledger_category_enum getLedger_category_enum() {
		return ledger_category_enum;
	}
	public void setLedger_category_enum(Ledger_category_enum ledger_category_enum) {
		this.ledger_category_enum = ledger_category_enum;
	}
	public BigDecimal getOpening_balance() {
		return opening_balance;
	}
	public void setOpening_balance(BigDecimal opening_balance) {
		this.opening_balance = opening_balance;
	}
	public BigDecimal getClosing_balance() {
		return closing_balance;
	}
	public void setClosing_balance(BigDecimal closing_balance) {
		this.closing_balance = closing_balance;
	}
	public Companies getCompany() {
		return company;
	}
	public void setCompany(Companies company) {
		this.company = company;
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
