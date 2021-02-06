package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayFiveService;

@RestController
public class DayFiveController {

	@Autowired
	private DayFiveService service;
	
	@GetMapping("/api-"+DayFiveService.ID+"-P1")
	public Long partOneGetExample() {
		return service.solvePartOneTask(DayFiveService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayFiveService.ID+"-P1")
	public Long partOneSolve(@RequestBody String input) {
		return service.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayFiveService.ID+"-P2")
	public Long partTwoGetExample() {
		return service.solvePartTwoTask(DayFiveService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayFiveService.ID+"-P2")
	public Long partTwoSolve(@RequestBody String input) {
		return service.solvePartTwoTask(input).getAnswer();
	}
}
