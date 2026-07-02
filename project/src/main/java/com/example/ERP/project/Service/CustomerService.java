package com.example.ERP.project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Customer;
import com.example.ERP.project.Repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	public Customer getCustomerById(long id) {
		return customerRepository.findById(id).orElse(null);
	}
	public Customer getCustomerByLedgerId(Long ledgerId) {
	    return customerRepository.findByLedgerId(ledgerId).orElse(null);
	}
	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	public Customer updateCustomer(long id, Customer customer) {
		Customer existingCustomer = customerRepository.findById(id).orElse(null);
		if (existingCustomer != null) {
			existingCustomer.setLedger(customer.getLedger());
			existingCustomer.setCustomer_code(customer.getCustomer_code());
			existingCustomer.setCustomer_name(customer.getCustomer_name());
			existingCustomer.setEmail(customer.getEmail());
			existingCustomer.setGstNumber(customer.getGstNumber());
			existingCustomer.setPhone(customer.getPhone());
			existingCustomer.setAddress(customer.getAddress());
			existingCustomer.setCredit_limit(customer.getCredit_limit());
			existingCustomer.setPayment_terms(customer.getPayment_terms());
			existingCustomer.setDiscount_percentage(customer.getDiscount_percentage());
			existingCustomer.setOpening_balance(customer.getOpening_balance());
			existingCustomer.setClosing_balance(customer.getClosing_balance());
			return customerRepository.save(existingCustomer);
		}
		return null;
	}
	public boolean deleteCustomer(long id) {
		Customer existingCustomer = customerRepository.findById(id).orElse(null);
		if (existingCustomer != null) {
			customerRepository.delete(existingCustomer);
			return true;
		}
		return false;
	}
	
}
