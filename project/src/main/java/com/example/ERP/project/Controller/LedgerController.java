package com.example.ERP.project.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ERP.project.Entity.Cash;
import com.example.ERP.project.Entity.Customer;
import com.example.ERP.project.Entity.Expenses;
import com.example.ERP.project.Entity.Income;
import com.example.ERP.project.Entity.Ledger;
import com.example.ERP.project.Entity.Supplier;
import com.example.ERP.project.Service.LedgerService;

@RestController
@RequestMapping("/api/ledger")
public class LedgerController {
	@Autowired
	private LedgerService ledgerService;
	@GetMapping
	public List<Ledger> getAllLedgers() {
		return ledgerService.getAllLedgers();
	}
	@GetMapping("/{id}")
	public ResponseEntity<Ledger> getLedgerById(@PathVariable Long id) {
		Ledger ledger = ledgerService.getLedgerById(id);
		if (ledger != null) {
			return ResponseEntity.ok(ledger);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@GetMapping("/company/{companyId}")
	public ResponseEntity<List<Ledger>> getLedgersByCompanyId(@PathVariable Long companyId) {
        List<Ledger> ledgers = ledgerService.getLedgersByCompanyId(companyId);
        if (ledgers != null && !ledgers.isEmpty()) {
            return ResponseEntity.ok(ledgers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	@GetMapping("/company/{companyId}/category/{category}")
    public ResponseEntity<List<Ledger>> getLedgersByCompanyAndCategory(
            @PathVariable Long companyId, 
            @PathVariable String category) {
        List<Ledger> ledgers = ledgerService.getLedgersByCompanyAndCategory(companyId, category);
        return ResponseEntity.ok(ledgers);
    }
	@GetMapping("/company/{companyId}/search")
    public ResponseEntity<List<Ledger>> searchLedgersByName(
            @PathVariable Long companyId, 
            @RequestParam String name) {
        List<Ledger> ledgers = ledgerService.searchLedgersByName(companyId, name);
        return ResponseEntity.ok(ledgers);
    }
	 @PostMapping
	    public ResponseEntity<Ledger> createLedger(@RequestBody Ledger ledger) {
	        Ledger createdLedger = ledgerService.createLedger(ledger);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdLedger);
	    }
	    
	    @PostMapping("/company/{companyId}")
	    public ResponseEntity<Ledger> createLedgerForCompany(
	            @PathVariable Long companyId, 
	            @RequestBody Ledger ledger) {
	        Ledger createdLedger = ledgerService.createLedgerForCompany(companyId, ledger);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdLedger);
	    }
	    @PutMapping("/{id}")
	    public ResponseEntity<Ledger> updateLedger(
	            @PathVariable Long id, 
	            @RequestBody Ledger ledger) {
	        Ledger updatedLedger = ledgerService.updateLedger(id, ledger);
	        if (updatedLedger != null) {
	            return ResponseEntity.ok(updatedLedger);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteLedger(@PathVariable Long id) {
	        ledgerService.deleteLedger(id);
	        return ResponseEntity.noContent().build();
	    }
	    // ============ LEDGER WITH CATEGORY DETAILS ============
	    
	    @GetMapping("/{id}/details")
	    public ResponseEntity<Map<String, Object>> getLedgerWithCategoryDetails(@PathVariable Long id) {
	        Map<String, Object> ledgerDetails = ledgerService.getLedgerWithCategoryDetails(id);
	        if (ledgerDetails != null) {
	            return ResponseEntity.ok(ledgerDetails);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @GetMapping("/company/{companyId}/all-details")
	    public ResponseEntity<List<Map<String, Object>>> getAllLedgersWithDetails(@PathVariable Long companyId) {
	        List<Map<String, Object>> ledgersWithDetails = ledgerService.getAllLedgersWithDetails(companyId);
	        return ResponseEntity.ok(ledgersWithDetails);
	    }
	    
	    // ============ CASH LEDGER OPERATIONS ============
	    
	    @PostMapping("/{ledgerId}/cash")
	    public ResponseEntity<Cash> createCashLedger(
	            @PathVariable Long ledgerId, 
	            @RequestBody Cash cash) {
	        Cash createdCash = ledgerService.createCashLedger(ledgerId, cash);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCash);
	    }
	    
	    @GetMapping("/{ledgerId}/cash")
	    public ResponseEntity<Cash> getCashDetails(@PathVariable Long ledgerId) {
	        Cash cash = ledgerService.getCashDetails(ledgerId);
	        if (cash != null) {
	            return ResponseEntity.ok(cash);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/cash/{cashId}")
	    public ResponseEntity<Cash> updateCashLedger(
	            @PathVariable Long cashId, 
	            @RequestBody Cash cash) {
	        Cash updatedCash = ledgerService.updateCashLedger(cashId, cash);
	        return ResponseEntity.ok(updatedCash);
	    }
	    
	    // ============ CUSTOMER LEDGER OPERATIONS ============
	    
	    @PostMapping("/{ledgerId}/customer")
	    public ResponseEntity<Customer> createCustomerLedger(
	            @PathVariable Long ledgerId, 
	            @RequestBody Customer customer) {
	        Customer createdCustomer = ledgerService.createCustomerLedger(ledgerId, customer);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
	    }
	    
	    @GetMapping("/{ledgerId}/customer")
	    public ResponseEntity<Customer> getCustomerDetails(@PathVariable Long ledgerId) {
	        Customer customer = ledgerService.getCustomerDetails(ledgerId);
	        if (customer != null) {
	            return ResponseEntity.ok(customer);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/customer/{customerId}")
	    public ResponseEntity<Customer> updateCustomerLedger(
	            @PathVariable Long customerId, 
	            @RequestBody Customer customer) {
	        Customer updatedCustomer = ledgerService.updateCustomerLedger(customerId, customer);
	        return ResponseEntity.ok(updatedCustomer);
	    }
	    
	    // ============ EXPENSES LEDGER OPERATIONS ============
	    
	    @PostMapping("/{ledgerId}/expense")
	    public ResponseEntity<Expenses> createExpenseLedger(
	            @PathVariable Long ledgerId, 
	            @RequestBody Expenses expense) {
	        Expenses createdExpense = ledgerService.createExpenseLedger(ledgerId, expense);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpense);
	    }
	    
	    @GetMapping("/{ledgerId}/expense")
	    public ResponseEntity<Expenses> getExpenseDetails(@PathVariable Long ledgerId) {
	        Expenses expense = ledgerService.getExpenseDetails(ledgerId);
	        if (expense != null) {
	            return ResponseEntity.ok(expense);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/expense/{expenseId}")
	    public ResponseEntity<Expenses> updateExpenseLedger(
	            @PathVariable Long expenseId, 
	            @RequestBody Expenses expense) {
	        Expenses updatedExpense = ledgerService.updateExpenseLedger(expenseId, expense);
	        return ResponseEntity.ok(updatedExpense);
	    }
	    
	    // ============ INCOME LEDGER OPERATIONS ============
	    
	    @PostMapping("/{ledgerId}/income")
	    public ResponseEntity<Income> createIncomeLedger(
	            @PathVariable Long ledgerId, 
	            @RequestBody Income income) {
	        Income createdIncome = ledgerService.createIncomeLedger(ledgerId, income);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
	    }
	    
	    @GetMapping("/{ledgerId}/income")
	    public ResponseEntity<Income> getIncomeDetails(@PathVariable Long ledgerId) {
	        Income income = ledgerService.getIncomeDetails(ledgerId);
	        if (income != null) {
	            return ResponseEntity.ok(income);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/income/{incomeId}")
	    public ResponseEntity<Income> updateIncomeLedger(
	            @PathVariable Long incomeId, 
	            @RequestBody Income income) {
	        Income updatedIncome = ledgerService.updateIncomeLedger(incomeId, income);
	        return ResponseEntity.ok(updatedIncome);
	    }
	    
	    // ============ SUPPLIER LEDGER OPERATIONS ============
	    
	    @PostMapping("/{ledgerId}/supplier")
	    public ResponseEntity<Supplier> createSupplierLedger(
	            @PathVariable Long ledgerId, 
	            @RequestBody Supplier supplier) {
	        Supplier createdSupplier = ledgerService.createSupplierLedger(ledgerId, supplier);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdSupplier);
	    }
	    
	    @GetMapping("/{ledgerId}/supplier")
	    public ResponseEntity<Supplier> getSupplierDetails(@PathVariable Long ledgerId) {
	        Supplier supplier = ledgerService.getSupplierDetails(ledgerId);
	        if (supplier != null) {
	            return ResponseEntity.ok(supplier);
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    @PutMapping("/supplier/{supplierId}")
	    public ResponseEntity<Supplier> updateSupplierLedger(
	            @PathVariable Long supplierId, 
	            @RequestBody Supplier supplier) {
	        Supplier updatedSupplier = ledgerService.updateSupplierLedger(supplierId, supplier);
	        return ResponseEntity.ok(updatedSupplier);
	    }
}
