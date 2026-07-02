package com.example.ERP.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	 @Query("SELECT c FROM Customer c WHERE c.ledger.id = :ledgerId")
	    Optional<Customer> findByLedgerId(@Param("ledgerId") Long ledgerId);
}
