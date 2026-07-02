package com.example.ERP.project.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ERP.project.Entity.Cash;
import com.example.ERP.project.Entity.Companies;
import com.example.ERP.project.Entity.Customer;
import com.example.ERP.project.Entity.Expenses;
import com.example.ERP.project.Entity.Income;
import com.example.ERP.project.Entity.Ledger;
import com.example.ERP.project.Entity.Supplier;
import com.example.ERP.project.Enum.Ledger_category_enum;
import com.example.ERP.project.Repository.LedgerRepository;

import jakarta.transaction.Transactional;

@Service
public class LedgerService {
	    
	@Autowired
	private LedgerRepository ledgerRepository;
	    
	@Autowired
	private CompanyService companyService;
	    
	@Autowired
	private CashService cashService;
	    
	    @Autowired
	    private CustomerService customerService;
	    
	    @Autowired
	    private ExpensesService expensesService;
	    
	    @Autowired
	    private IncomeService incomeService;
	    
	    @Autowired
	    private SupplierService supplierService;
	    
	    // ============ LEDGER CRUD OPERATIONS ============
	    
	    public List<Ledger> getAllLedgers() {
	        return ledgerRepository.findAll();
	    }
	    
	    public Ledger getLedgerById(Long id) {
	        return ledgerRepository.findById(id).orElse(null);
	    }
	    
	    public List<Ledger> getLedgersByCompanyId(Long companyId) {
	        return ledgerRepository.findByCompanyId(companyId);
	    }
	    
	    public List<Ledger> getLedgersByCompanyAndCategory(Long companyId, String category) {
	        return ledgerRepository.findByCompanyIdAndCategory(companyId, category);
	    }
	    
	    public List<Ledger> searchLedgersByName(Long companyId, String name) {
	        return ledgerRepository.findByCompanyIdAndNameContaining(companyId, name);
	    }
	    
	    @Transactional
	    public Ledger createLedger(Ledger ledger) {
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        ledger.setCreatedAt(now);
	        ledger.setUpdatedAt(now);
	        
	        // Auto-generate ledger code if not provided
	        if (ledger.getLedger_code() == null || ledger.getLedger_code().isEmpty()) {
	            ledger.setLedger_code(generateLedgerCode(ledger));
	        }
	        
	        return ledgerRepository.save(ledger);
	    }
	    
	    @Transactional
	    public Ledger createLedgerForCompany(Long companyId, Ledger ledger) {
	        Companies company = companyService.getCompanyById(companyId);
	        if (company == null) {
	            throw new RuntimeException("Company not found with ID: " + companyId);
	        }
	        
	        ledger.setCompany(company);
	        return createLedger(ledger);
	    }
	    
	    @Transactional
	    public Ledger updateLedger(Long id, Ledger ledger) {
	        Ledger existingLedger = ledgerRepository.findById(id).orElse(null);
	        if (existingLedger != null) {
	            existingLedger.setLedger_name(ledger.getLedger_name());
	            existingLedger.setLedger_code(ledger.getLedger_code());
	            existingLedger.setLedger_enum(ledger.getLedger_enum());
	            existingLedger.setLedger_category_enum(ledger.getLedger_category_enum());
	            existingLedger.setOpening_balance(ledger.getOpening_balance());
	            existingLedger.setClosing_balance(ledger.getClosing_balance());
	            if (ledger.getCompany() != null) {
	                existingLedger.setCompany(ledger.getCompany());
	            }
	            existingLedger.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
	            return ledgerRepository.save(existingLedger);
	        }
	        return null;
	    }
	    
	    @Transactional
	    public void deleteLedger(Long id) {
	        // First delete associated category details
	        deleteAssociatedCategoryDetails(id);
	        // Then delete the ledger
	        ledgerRepository.deleteById(id);
	    }
	    
	    // ============ LEDGER WITH CATEGORY DETAILS ============
	    
	    public Map<String, Object> getLedgerWithCategoryDetails(Long ledgerId) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            return null;
	        }
	        
	        Map<String, Object> result = new HashMap<>();
	        result.put("ledger", ledger);
	        
	        // Get category details based on ledger type
	        Ledger_category_enum category = ledger.getLedger_category_enum();
	        
	        if (category == Ledger_category_enum.CASH) {
	            Cash cash = cashService.getCashByLedgerId(ledgerId);
	            if (cash != null) {
	                result.put("categoryDetails", cash);
	                result.put("categoryType", "CASH");
	            }
	        } else if (category == Ledger_category_enum.CUSTOMER) {
	            Customer customer = customerService.getCustomerByLedgerId(ledgerId);
	            if (customer != null) {
	                result.put("categoryDetails", customer);
	                result.put("categoryType", "CUSTOMER");
	            }
	        } else if (category == Ledger_category_enum.EXPENSES) {
	            Expenses expense = expensesService.getExpensesByLedgerId(ledgerId);
	            if (expense != null) {
	                result.put("categoryDetails", expense);
	                result.put("categoryType", "EXPENSES");
	            }
	        } else if (category == Ledger_category_enum.INCOME) {
	            Income income = incomeService.getIncomeByLedgerId(ledgerId);
	            if (income != null) {
	                result.put("categoryDetails", income);
	                result.put("categoryType", "INCOME");
	            }
	        } else if (category == Ledger_category_enum.SUPPLIER) {
	            Supplier supplier = supplierService.getSupplierByLedgerId(ledgerId);
	            if (supplier != null) {
	                result.put("categoryDetails", supplier);
	                result.put("categoryType", "SUPPLIER");
	            }
	        }
	        
	        return result;
	    }
	    
	    public List<Map<String, Object>> getAllLedgersWithDetails(Long companyId) {
	        List<Ledger> ledgers = getLedgersByCompanyId(companyId);
	        List<Map<String, Object>> result = new ArrayList<>();
	        
	        for (Ledger ledger : ledgers) {
	            Map<String, Object> ledgerWithDetails = getLedgerWithCategoryDetails(ledger.getId());
	            if (ledgerWithDetails != null) {
	                result.add(ledgerWithDetails);
	            }
	        }
	        
	        return result;
	    }
	    
	    // ============ CASH LEDGER OPERATIONS ============
	    
	    @Transactional
	    public Cash createCashLedger(Long ledgerId, Cash cash) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            throw new RuntimeException("Ledger not found with ID: " + ledgerId);
	        }
	        
	        // Set the ledger reference
	        cash.setLedger(ledger);
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        cash.setCreatedAt(now);
	        cash.setUpdatedAt(now);
	        
	        // Update ledger category
	        ledger.setLedger_category_enum(Ledger_category_enum.CASH);
	        ledger.setUpdatedAt(now);
	        ledgerRepository.save(ledger);
	        
	        return cashService.createCash(cash);
	    }
	    
	    public Cash getCashDetails(Long ledgerId) {
	        return cashService.getCashByLedgerId(ledgerId);
	    }
	    
	    @Transactional
	    public Cash updateCashLedger(Long cashId, Cash cash) {
	        return cashService.updateCash(cashId, cash);
	    }
	    
	    // ============ CUSTOMER LEDGER OPERATIONS ============
	    
	    @Transactional
	    public Customer createCustomerLedger(Long ledgerId, Customer customer) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            throw new RuntimeException("Ledger not found with ID: " + ledgerId);
	        }
	        
	        customer.setLedger(ledger);
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        customer.setCreatedAt(now);
	        customer.setUpdatedAt(now);
	        
	        ledger.setLedger_category_enum(Ledger_category_enum.CUSTOMER);
	        ledger.setUpdatedAt(now);
	        ledgerRepository.save(ledger);
	        
	        return customerService.createCustomer(customer);
	    }
	    
	    public Customer getCustomerDetails(Long ledgerId) {
	        return customerService.getCustomerByLedgerId(ledgerId);
	    }
	    
	    @Transactional
	    public Customer updateCustomerLedger(Long customerId, Customer customer) {
	        return customerService.updateCustomer(customerId, customer);
	    }
	    
	    // ============ EXPENSES LEDGER OPERATIONS ============
	    
	    @Transactional
	    public Expenses createExpenseLedger(Long ledgerId, Expenses expense) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            throw new RuntimeException("Ledger not found with ID: " + ledgerId);
	        }
	        
	        expense.setLedger(ledger);
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        expense.setCreatedAt(now);
	        expense.setUpdatedAt(now);
	        
	        ledger.setLedger_category_enum(Ledger_category_enum.EXPENSES);
	        ledger.setUpdatedAt(now);
	        ledgerRepository.save(ledger);
	        
	        return expensesService.createExpenses(expense);
	    }
	    
	    public Expenses getExpenseDetails(Long ledgerId) {
	        return expensesService.getExpensesByLedgerId(ledgerId);
	    }
	    
	    @Transactional
	    public Expenses updateExpenseLedger(Long expenseId, Expenses expense) {
	        return expensesService.updateExpenses(expenseId, expense);
	    }
	    
	    // ============ INCOME LEDGER OPERATIONS ============
	    
	    @Transactional
	    public Income createIncomeLedger(Long ledgerId, Income income) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            throw new RuntimeException("Ledger not found with ID: " + ledgerId);
	        }
	        
	        income.setLedger(ledger);
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        income.setCreatedAt(now);
	        income.setUpdatedAt(now);
	        
	        ledger.setLedger_category_enum(Ledger_category_enum.INCOME);
	        ledger.setUpdatedAt(now);
	        ledgerRepository.save(ledger);
	        
	        return incomeService.createIncome(income);
	    }
	    
	    public Income getIncomeDetails(Long ledgerId) {
	        return incomeService.getIncomeByLedgerId(ledgerId);
	    }
	    
	    @Transactional
	    public Income updateIncomeLedger(Long incomeId, Income income) {
	        return incomeService.updateIncome(incomeId, income);
	    }
	    
	    // ============ SUPPLIER LEDGER OPERATIONS ============
	    
	    @Transactional
	    public Supplier createSupplierLedger(Long ledgerId, Supplier supplier) {
	        Ledger ledger = getLedgerById(ledgerId);
	        if (ledger == null) {
	            throw new RuntimeException("Ledger not found with ID: " + ledgerId);
	        }
	        
	        supplier.setLedger(ledger);
	        Timestamp now = new Timestamp(System.currentTimeMillis());
	        supplier.setCreatedAt(now);
	        supplier.setUpdatedAt(now);
	        
	        ledger.setLedger_category_enum(Ledger_category_enum.SUPPLIER);
	        ledger.setUpdatedAt(now);
	        ledgerRepository.save(ledger);
	        
	        return supplierService.createSupplier(supplier);
	    }
	    
	    public Supplier getSupplierDetails(Long ledgerId) {
	        return supplierService.getSupplierByLedgerId(ledgerId);
	    }
	    
	    @Transactional
	    public Supplier updateSupplierLedger(Long supplierId, Supplier supplier) {
	        return supplierService.updateSupplier(supplierId, supplier);
	    }
	    
	    // ============ PRIVATE HELPER METHODS ============
	    
	    private String generateLedgerCode(Ledger ledger) {
	        String prefix = "L";
	        if (ledger.getLedger_category_enum() != null) {
	            prefix = ledger.getLedger_category_enum().name().substring(0, 3).toUpperCase();
	        }
	        String timestamp = String.valueOf(System.currentTimeMillis()).substring(8, 13);
	        return prefix + timestamp;
	    }
	    
	    private void deleteAssociatedCategoryDetails(Long ledgerId) {
	        // Delete associated category details
	        Cash cash = cashService.getCashByLedgerId(ledgerId);
	        if (cash != null) {
	            cashService.deleteCash(cash.getId());
	        }
	        
	        Customer customer = customerService.getCustomerByLedgerId(ledgerId);
	        if (customer != null) {
	            customerService.deleteCustomer(customer.getId());
	        }
	        
	        Expenses expense = expensesService.getExpensesByLedgerId(ledgerId);
	        if (expense != null) {
	            expensesService.deleteExpenses(expense.getId());
	        }
	        
	        Income income = incomeService.getIncomeByLedgerId(ledgerId);
	        if (income != null) {
	            incomeService.deleteIncome(income.getId());
	        }
	        
	        Supplier supplier = supplierService.getSupplierByLedgerId(ledgerId);
	        if (supplier != null) {
	            supplierService.deleteSupplier(supplier.getId());
	        }
	    }
}
