package com.example.ERP.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Cash;

public interface CashRepository extends JpaRepository<Cash, Long> {
	@Query("SELECT c FROM Cash c WHERE c.ledger.id = :ledgerId")
    Optional<Cash> findByLedgerId(@Param("ledgerId") Long ledgerId);
}
