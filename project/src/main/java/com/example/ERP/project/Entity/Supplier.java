package com.example.ERP.project.Entity;

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
@Table(name = "supplier_ledger")
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ledgers_id",columnDefinition = "BIGINT")
	private Ledger ledger;
	private String supplier_code;
	private String supplier_name;
	private String email;
	private String gstNumber;
	private String phone;
	private String address;
	private int credit_period;
	private String pan_number;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Supplier() {
		super();
	}
	public Supplier(long id, Ledger ledger, String supplier_code, String supplier_name, String email,
			String gstNumber, String phone, String address, int credit_period, String pan_number) {
		super();
		this.id = id;
		this.ledger = ledger;
		this.supplier_code = supplier_code;
		this.supplier_name = supplier_name;
		this.email = email;
		this.gstNumber = gstNumber;
		this.phone = phone;
		this.address = address;
		this.credit_period = credit_period;
		this.pan_number = pan_number;
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
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getSupplier_name() {
		return supplier_name;
	}
	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
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
	public int getCredit_period() {
		return credit_period;
	}
	public void setCredit_period(int credit_period) {
		this.credit_period = credit_period;
	}
	public String getPan_number() {
		return pan_number;
	}
	public void setPan_number(String pan_number) {
		this.pan_number = pan_number;
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
