package com.example.demo.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class IncomeDTO {
	private Long id;
	private String title;
	private Double amount;
	private LocalDate date;
	private String category;
	private String description;
	public void setID(Long id) {
       this.id =id;
       
	}
	public void setAmount(Double amount2) {
	       this.amount =amount2;
	       
		}
	public void setTitle(String title) {
	       this.title =title;
	       
		}
	public void setDate(LocalDate date) {
	       this.date =date;
	       
		}
	public void setID(String description) {
	       this.description =description;
	       
		}
	public void setCategory(String category) {
	       this.category =category;
	       
		}
	public String getTitle() {
		return title;
	}
	public Double getAmount() {
		return amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public String getDescription() {
		return description;
	}
	public String getCategory() {
		return category;
	}
	

}
