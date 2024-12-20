package com.example.demo.services.Stats;

import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GraphDTO;
import com.example.demo.dto.StatsDTO;
import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import com.example.demo.repository.ExpenseRepository;
import com.example.demo.repository.IncomeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Data
@Service
@RequiredArgsConstructor
public class StatsServiceImpl implements StatsService{
	@Autowired
	private IncomeRepository incomeRepository;
	@Autowired
	private ExpenseRepository expenseRepository;
	
	public GraphDTO getChartData()
	{
		LocalDate endDate = LocalDate.now();
		LocalDate startDate = endDate.minusDays(27);
		GraphDTO graphDTO = new GraphDTO();
		 graphDTO.setExpenseList(expenseRepository.findByDateBetween(startDate,endDate));
		 graphDTO.setIncomeList(incomeRepository.findByDateBetween(startDate,endDate));
		 return graphDTO;
	}
	
	public StatsDTO getStats() {
		
		Double totalIncome = Optional.ofNullable(incomeRepository.sumAllAmount()).orElse(0.0);
		Double totalExpense = Optional.ofNullable(expenseRepository.sumAllAmount()).orElse(0.0);
		
		Optional<Income> optionalIncome = incomeRepository.findFirstByOrderByDateDesc();
		Optional<Expense> optionalExpense= expenseRepository.findFirstByOrderByDateDesc();

		
		StatsDTO statsDTO = new StatsDTO();
		statsDTO.setTotalExpense(totalExpense);
		statsDTO.setTotalIncome(totalIncome);
		
		                
	   optionalIncome.ifPresent(statsDTO::setLatestIncome);		
	   optionalExpense.ifPresent(statsDTO::setLatestExpense);
		
	   statsDTO.setBalance(totalIncome-totalExpense);
	   List<Income> incomeList =incomeRepository.findAll();
	   List<Expense> expenseList = expenseRepository.findAll();
	   
	   OptionalDouble minIncome =incomeList.stream().mapToDouble(Income::getAmount).min();
	   OptionalDouble maxIncome = incomeList.stream().mapToDouble(Income::getAmount).max();
	   
	   OptionalDouble minExpense =expenseList.stream().mapToDouble(Expense::getAmount).min();
	   OptionalDouble maxExpense = expenseList.stream().mapToDouble(Expense::getAmount).max();
	   
	   statsDTO.setMaxExpense(maxExpense.isPresent()? maxExpense.getAsDouble():null);
	   statsDTO.setMinExpense(minExpense.isPresent()? minExpense.getAsDouble():null);
	   
	   statsDTO.setMaxIncome(maxIncome.isPresent()? maxIncome.getAsDouble():null);
	   statsDTO.setMinIncome(minIncome.isPresent()? minIncome.getAsDouble():null);
		return statsDTO;
		
		
		
		
	}

}
