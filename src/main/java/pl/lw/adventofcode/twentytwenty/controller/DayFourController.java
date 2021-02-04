package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayFourService;

@RestController
public class DayFourController {
	
	@Autowired
	private DayFourService service;
	
	@GetMapping("/api-"+DayFourService.ID+"-P1")
	public Long partOneGetExample() {
		return service.solvePartOneTask(DayFourService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayFourService.ID+"-P1")
	public Long partOneSolve(@RequestBody String input) {
		return service.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayFourService.ID+"-P2")
	public Long partTwoGetExample() {
		return service.solvePartTwoTask(DayFourService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayFourService.ID+"-P2")
	public Long partTwoSolve(@RequestBody String input) {
		return service.solvePartTwoTask(input).getAnswer();
	}
}
