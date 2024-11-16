package com.example.demo.dto;
import lombok.Data;

import java.util.List;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;

@Data
public class GraphDTO {
	private List<Expense> expenselist;
	private List<Income> incomelist;
	public void setExpenseList(List<Expense> expenseList) {
             this.expenselist=expenseList;
	}
	public void setIncomeList(List<Income> incomeList) {
             this.incomelist=incomeList;
	}
	
	


}
	
	
	
	

	
	
	
	


