package com.example.demo.services.Income;

import java.util.List;

import com.example.demo.dto.IncomeDTO;
import com.example.demo.entity.Income;

public interface IncomeService {

	Income postIncome(IncomeDTO incomeDTO);
	List<IncomeDTO> getAllIncome();
	Income updateIncome(Long id,IncomeDTO incomeDTO);
	IncomeDTO getIncomeById(Long id);
	public void deleteIncome(Long id);

}
