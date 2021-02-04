package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayThreeService;

@RestController
public class DayThreeController {
	
	@Autowired
	private DayThreeService service;
	
	@GetMapping("/api-"+DayThreeService.ID+"-P1")
	public Long partOneGetExample() {
		return service.solvePartOneTask(DayThreeService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P1")
	public Long partOneSolve(@RequestBody String input) {
		return service.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayThreeService.ID+"-P2")
	public Long partTwoGetExample() {
		return service.solvePartTwoTask(DayThreeService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P2")
	public Long partTwoSolve(@RequestBody String input) {
		return service.solvePartTwoTask(input).getAnswer();
	}
}
