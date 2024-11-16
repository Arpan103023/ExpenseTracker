package com.example.demo.services.Stats;

import com.example.demo.dto.GraphDTO;
import com.example.demo.dto.StatsDTO;

public interface StatsService {
	GraphDTO getChartData();
	StatsDTO getStats();
	
}
