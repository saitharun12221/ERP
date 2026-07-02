package com.example.ERP.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
	@Query("SELECT s FROM Supplier s WHERE s.ledger.id = :ledgerId")
    Optional<Supplier> findByLedgerId(@Param("ledgerId") Long ledgerId);
}
