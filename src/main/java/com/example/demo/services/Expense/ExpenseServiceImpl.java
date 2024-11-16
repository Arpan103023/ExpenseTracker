package com.example.demo.services.Expense;

import com.example.demo.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;

import com.example.demo.dto.ExpenseDto;
import com.example.demo.entity.Expense;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
   @Autowired
   private  ExpenseRepository expenseRepository;
   @Override
   public Expense postExpense(ExpenseDto expenseDTO)
   {
	   return saveOrUpdateExpense(new Expense(), expenseDTO );
   }
   private Expense saveOrUpdateExpense(Expense expense,ExpenseDto expenseDTO)
   {
	   expense.setTitle(expenseDTO.getTitle());
	   expense.setDate(expenseDTO.getDate());
	   expense.setAmount(expenseDTO.getAmount());
	   expense.setCategory(expenseDTO.getCategory());
	   expense.setDescription(expenseDTO.getDescription());
	   return expenseRepository.save(expense);
   }
   public List<Expense> getAllExpenses()
   {
	   return expenseRepository.findAll().stream().sorted(Comparator.comparing(Expense::getDate).reversed()).collect(Collectors.toList());

   }
   public Expense updateExpense(Long id,ExpenseDto expensedto) {
	   Optional<Expense> optionalExpense =expenseRepository.findById(id);
	   if(optionalExpense.isPresent())
	   {
		   return saveOrUpdateExpense(optionalExpense.get(), expensedto);
		   
	   }
	   else {
		   throw new EntityNotFoundException("Expense is not present with id"+id);
	   }
	   
	   
   }
public Expense getExpenseById(Long id)
{
	Optional<Expense> optionalExpense =expenseRepository.findById(id);
	if(optionalExpense.isPresent())
	{
		return optionalExpense.get();
		
	}
	else 
	{
		throw new EntityNotFoundException("Expense is not present with id "+id);
	}
	
	}

public void deleteExpense(Long id)
{
	Optional<Expense> optionalExpense = expenseRepository.findById(id);
	if(optionalExpense.isPresent())
	{
	expenseRepository.deleteById(id);	
	}
	else {
		throw new EntityNotFoundException("Expense is not present with id" +id); 
	}
	
	}

  
}

