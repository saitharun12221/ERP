package com.example.ERP.project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ERP.project.Entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
