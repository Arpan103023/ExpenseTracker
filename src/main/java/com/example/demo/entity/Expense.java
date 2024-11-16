package com.example.demo.entity;
import jakarta.persistence.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Id;
import jakarta.persistence.GenerationType;
import jakarta.persistence.GeneratedValue;

import java.time.LocalDate;
import lombok.Data;

@Entity
@Data
public class Expense {
    @Id	
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
    
    private String title;
    
    private String description;
    private String category;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
	private double amount;
	public void setTitle(String title2) {
		this.title =title2;
		
	}
	
	
	public void setAmount(double amount)
	{
		this.amount=amount;
	}
	public void setCategory(String category2) {
		this.category=category2;
		
	}
	
	public void setDescription(String description2)
	{
		this.description=description2;
	}
	public void setDate(LocalDate date2) {
		this.date=date2;
		
	}
  public LocalDate getDate()
  {
	return date;
	  
  }
public String getTitle()
{
	return title;}
public String getdescription()
{
	return description;}
public double getAmount()
{
	return amount;}
public String getCategory()

{
	return category;}
	
}
