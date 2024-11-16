package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.GraphDTO;
import com.example.demo.services.Stats.StatsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class StatsController {
	@Autowired

	private StatsService statsService;
	@GetMapping("/chart")
	public ResponseEntity<GraphDTO> getChartDetails(){
		
		return ResponseEntity.ok(statsService.getChartData());

}
	
	@GetMapping("/total")
	public ResponseEntity<?> getStats(){
		
	    return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(statsService.getStats());
		
	}
}