package com.example.ERP.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ERP.project.Entity.Ledger;

public interface LedgerRepository extends JpaRepository<Ledger, Long> {
List<Ledger> findByCompanyId(Long companyId);
    
    @Query("SELECT l FROM Ledger l WHERE l.company.id = :companyId AND l.ledger_category = :category")
    List<Ledger> findByCompanyIdAndCategory(@Param("companyId") Long companyId, 
                                           @Param("category") String category);
    
    @Query("SELECT l FROM Ledger l WHERE l.company.id = :companyId AND l.ledger_name LIKE %:name%")
    List<Ledger> findByCompanyIdAndNameContaining(@Param("companyId") Long companyId, 
                                                  @Param("name") String name);
}
