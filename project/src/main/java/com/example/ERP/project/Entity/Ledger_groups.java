package com.example.ERP.project.Entity;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

public class Ledger_groups {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Ledger Group Name is Required")
	private String group_name;
	@NotBlank(message = "Description is Required")
	private String description;
	@NotBlank(message = "Status is Required")
	private String status;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	public Ledger_groups() {
		super();
	}
	public Ledger_groups(long id, String group_name, String description, String status, Timestamp createdAt,
			Timestamp updatedAt) {
		super();
		this.id = id;
		this.group_name = group_name;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
