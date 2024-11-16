package com.example.demo.dto;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import lombok.*;

@Data
public class StatsDTO {
	
	private Double totalincome=0.0;
	private Double totalexpense=0.0;
	
	private Income latestIncome;
	private Expense latestExpense;
	
	
	    private Double totalIncome;
	    private Double totalExpense;
	   
	    private Double minExpense;
	    private Double maxExpense;
	    private Double minIncome;
	    private Double maxIncome;

	    private Double balance = totalincome-totalexpense;
	    
	    public Double getTotalIncome() {
	        return totalIncome;
	    }

	    public void setTotalIncome(Double totalIncome) {
	        this.totalIncome = totalIncome;
	    }

	    public Double getTotalExpense() {
	        return totalExpense;
	    }

	    public void setTotalExpense(Double totalExpense) {
	        this.totalExpense = totalExpense;
	    }

	    public Income getLatestIncome() {
	        return latestIncome;
	    }

	    public void setLatestIncome(Income latestIncome) {
	        this.latestIncome = latestIncome;
	    }

	    public Expense getLatestExpense() {
	        return latestExpense;
	    }

	    public void setLatestExpense(Expense latestExpense) {
	        this.latestExpense = latestExpense;
	    }
	    
	    public void setBalance(Double balance)
	    {
	    	this.balance =balance;
	    }
	    public Double getBalance()
	    {
	    	return balance;
	    }

		public void setMinExpense(Double minExpense) {
			
			this.minExpense =minExpense;

			
		}
	public void setMaxExpense(Double maxExpense) {
			
			this.maxExpense =maxExpense;

			
		}
	public Double getMaxExpense()
	{
		return maxExpense;
	}
	public Double getMinExpense()
	{
		return minExpense;
	}
	public void setMinIncome(Double minIncome) {
		
		this.minIncome=minIncome;
}
	public void setMaxIncome(Double maxIncome)
	{
		this.maxIncome=maxIncome;
	}
	public Double getMinIncome()
	{
		return minIncome;
		
	}
	public Double getMaxIncome()
	{
		return maxIncome;
	}
	
	
	
	
	
	}
	

	

	
	
	


