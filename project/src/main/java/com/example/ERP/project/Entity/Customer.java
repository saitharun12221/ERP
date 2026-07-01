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
@Table(name = "customer_ledger")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ledgers_id")
	private Ledger ledger;
	private String customer_code;
	private String customer_name;
	private String email;
	private String gstNumber;
	private String phone;
	private String address;
	private BigDecimal credit_limit;
	private int payment_terms;
	private BigDecimal discount_percentage;
	private BigDecimal opening_balance;
	private BigDecimal closing_balance;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Customer() {
		super();
	}
	public Customer(long id, Ledger ledger, String customer_code, String customer_name, String email,
			String gstNumber, String phone, String address, BigDecimal credit_limit, int payment_terms,
			BigDecimal discount_percentage, BigDecimal opening_balance, BigDecimal closing_balance,
			Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.ledger = ledger;
		this.customer_code = customer_code;
		this.customer_name = customer_name;
		this.email = email;
		this.gstNumber = gstNumber;
		this.phone = phone;
		this.address = address;
		this.credit_limit = credit_limit;
		this.payment_terms = payment_terms;
		this.discount_percentage = discount_percentage;
		this.opening_balance = opening_balance;
		this.closing_balance = closing_balance;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Ledger getLedger() {
		return ledger;
	}
	public void setLedger(Ledger ledger) {
		this.ledger = ledger;
	}
	public String getCustomer_code() {
		return customer_code;
	}
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getCredit_limit() {
		return credit_limit;
	}
	public void setCredit_limit(BigDecimal credit_limit) {
		this.credit_limit = credit_limit;
	}
	public int getPayment_terms() {
		return payment_terms;
	}
	public void setPayment_terms(int payment_terms) {
		this.payment_terms = payment_terms;
	}
	public BigDecimal getDiscount_percentage() {
		return discount_percentage;
	}
	public void setDiscount_percentage(BigDecimal discount_percentage) {
		this.discount_percentage = discount_percentage;
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

	
