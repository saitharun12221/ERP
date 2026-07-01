package com.example.ERP.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.project.Entity.Cash;

public interface CashRepository extends JpaRepository<Cash, Long> {
	

}
