package com.example.ERP.project.Enum;

public enum Ledger_enum {
	ASSET("Asset"),
	LIABILITY("Liability"),
	INCOME("Income"),
	EXPENSE("Expense");

	private final String value;

	Ledger_enum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
