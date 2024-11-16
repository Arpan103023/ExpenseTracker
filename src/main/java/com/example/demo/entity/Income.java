package com.example.demo.entity;

import java.time.LocalDate;

import com.example.demo.dto.IncomeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Income {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Double amount;
	private LocalDate date;
	private String category;
	private String description;
	
	public IncomeDTO getIncomeDto()

	{
		
	IncomeDTO incomeDTO = new IncomeDTO();
	incomeDTO.setID(id);
	incomeDTO.setTitle(title);

	incomeDTO.setAmount(amount);
	incomeDTO.setDate(date);
	incomeDTO.setCategory(category);
	incomeDTO.setID(description);
  
	return incomeDTO;
	
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	  public LocalDate getDate()
	  {
		return date;
		  
	  }

	
}
