package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.IncomeDTO;
import com.example.demo.entity.Income;
import com.example.demo.services.Income.IncomeService;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/income")
@RequiredArgsConstructor
@CrossOrigin("*")
public class IncomeController {
    @Autowired
	private IncomeService incomeService;
	@PostMapping("/add")
	public ResponseEntity<?> postIncome(@RequestBody IncomeDTO incomeDTO)
	{
		Income createdIncome = incomeService.postIncome(incomeDTO);
		
		if(createdIncome !=null)
		{
			return ResponseEntity.status(HttpStatus.CREATED).body(createdIncome);
		}
		else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllIncome()
	
	{
		return ResponseEntity.ok(incomeService.getAllIncome());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateIncome(@PathVariable Long id,@RequestBody IncomeDTO incomeDTO)
	{
		try {
			return ResponseEntity.ok(incomeService.updateIncome(id, incomeDTO));
		}
		catch(EntityNotFoundException ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
	@GetMapping("/{id}")
	
	public ResponseEntity<?> getIncomeById(@PathVariable long id)
	{
		try {
			return ResponseEntity.ok(incomeService.getIncomeById(id));
			
		}
		catch(EntityNotFoundException ex)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
		}
		catch(Exception e)
		{
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
		}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?>  deleteIncome(@PathVariable Long id)
	{
		
				try { 
					incomeService.deleteIncome(id);
					return ResponseEntity.ok("Income Deleted");
				}
				catch(EntityNotFoundException e){
					
					return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
				}
				catch(Exception e){
					return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
				}
	
	}
}

