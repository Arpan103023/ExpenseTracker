package com.example.demo.services.Expense;

import java.util.List;

import com.example.demo.dto.ExpenseDto;
import com.example.demo.entity.Expense;

public interface ExpenseService{
	Expense postExpense(ExpenseDto expenseDTO);

	List<Expense> getAllExpenses();
	Expense getExpenseById(Long id);

	Expense updateExpense(Long id, ExpenseDto dto);
    void deleteExpense(Long id);

	
	
}