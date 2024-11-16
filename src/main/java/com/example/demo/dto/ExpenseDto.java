package com.example.demo.dto;

import lombok.Data;
import java.time.*;

@Data

public class ExpenseDto {

	private long id;
	private String title;
	
	private String description;
	private int amount ;
	private String category;
	private LocalDate date;
	public String getTitle() {
		//
		return title;
	}
	public LocalDate getDate() {
		
		return date;
	}
	public Integer getAmount() {
		return amount;
	}
	public String getCategory() {
	
		return category;
	}
	public String getDescription() {
		
		return description;
	}
	
}
