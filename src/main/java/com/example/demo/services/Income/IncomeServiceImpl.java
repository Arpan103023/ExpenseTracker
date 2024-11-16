package com.example.demo.services.Income;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.IncomeDTO;
import com.example.demo.entity.Income;
import com.example.demo.repository.IncomeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {
    @Autowired
	private IncomeRepository incomeRepository;
	
	public Income postIncome(IncomeDTO incomeDTO)
	{
		return saveORUpdateIncome(new Income(),incomeDTO);
	}
	private Income saveORUpdateIncome(Income income,IncomeDTO incomeDTO)
	{
		income.setTitle(incomeDTO.getTitle());
		income.setDate(incomeDTO.getDate());
		income.setDescription(incomeDTO.getDescription());
		income.setCategory(incomeDTO.getCategory());
		income.setAmount(incomeDTO.getAmount());
		
		
		return incomeRepository.save(income);
		
	}
	public IncomeDTO getIncomeById(Long id)
	{
		Optional<Income> optionalIncome = incomeRepository.findById(id);
		if(optionalIncome.isPresent())
		{
			return optionalIncome.get().getIncomeDto();
		}
		else {
			throw new EntityNotFoundException("Income is not present with id "+id);
		}
		
	}
	public Income updateIncome(Long id,IncomeDTO incomeDTO)
	{	Optional<Income> optionalIncome =incomeRepository.findById(id);
	if(optionalIncome.isPresent())
	{
		return saveORUpdateIncome(optionalIncome.get(),incomeDTO);
	}
	else {
		throw new EntityNotFoundException("Income is not present with id");
	}
}
	public void deleteIncome(Long id)
	{
		Optional<Income> optionalIncome = incomeRepository.findById(id);
		if(optionalIncome.isPresent())
		{
		incomeRepository.deleteById(id);	
		}
		else {
			throw new EntityNotFoundException("Expense is not present with id" +id); 
		}
		
		}
	
	
	public List<IncomeDTO> getAllIncome(){
		return incomeRepository.findAll().stream().sorted(Comparator.comparing(Income::getDate).reversed()).map(Income::getIncomeDto)
				.collect(Collectors.toList());
		
	}
	
	
}
