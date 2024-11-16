package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.*;

import java.time.LocalDate;
import java.util.*;
@Repository
public interface IncomeRepository  extends JpaRepository<Income, Long>{


	List<Income> findByDateBetween(LocalDate startDate, LocalDate endDate);
	
	@Query("SELECT SUM(i.amount) FROM Income i")
	Double sumAllAmount();

	Optional<Income> findFirstByOrderByDateDesc();

}
