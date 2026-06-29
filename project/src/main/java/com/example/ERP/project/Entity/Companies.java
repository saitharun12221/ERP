package com.example.ERP.project.Entity;

import java.sql.Timestamp;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Table(name = "companies")
public class Companies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank(message = "Company Name is Required")
	private String company_name;
	@NotBlank(message="industry is Required")
	private String industry;
	@NotBlank(message="webSite is Required")
	private String webSite;
	@NotBlank(message="email is Required")
	private String email;
	@NotBlank(message="phone is Required")
	private String phone;
	@NotBlank(message="address is Required")
	private String address;
	@NotBlank(message="city is Required")
	private String city;
	@NotBlank(message="state is Required")
	private String state;
	@NotBlank(message="country is Required")
	private String country;
	private Timestamp createdAt;
	private	Timestamp updatedAt;
	public Companies() {
		super();
	}
	public Companies(long id, String company_name, String industry, String webSite, String email, String phone,
			String address, String city, String state, String country, Timestamp createdAt, Timestamp updatedAt) {
		super();
		this.id = id;
		this.company_name = company_name;
		this.industry = industry;
		this.webSite = webSite;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.city = city;
		this.state = state;
		this.country = country;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getWebSite() {
		return webSite;
	}
	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
