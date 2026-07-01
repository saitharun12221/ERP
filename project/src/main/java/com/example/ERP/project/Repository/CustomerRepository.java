package com.example.ERP.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.project.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
