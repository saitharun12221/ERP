package com.example.ERP.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.project.Entity.Ledger;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {

}
