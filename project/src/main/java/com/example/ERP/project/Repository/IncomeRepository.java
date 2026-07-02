package com.example.ERP.project.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    @Query("SELECT i FROM Income i WHERE i.ledger.id = :ledgerId")
    Optional<Income> findByLedgerId(@Param("ledgerId") Long ledgerId);
}
