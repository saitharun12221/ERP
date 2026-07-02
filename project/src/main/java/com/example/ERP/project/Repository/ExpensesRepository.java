package com.example.ERP.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
	 @Query("SELECT e FROM Expenses e WHERE e.ledger.id = :ledgerId")
	    Optional<Expenses> findByLedgerId(@Param("ledgerId") Long ledgerId);
}
