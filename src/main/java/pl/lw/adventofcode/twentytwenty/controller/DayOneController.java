package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayOneService;

@RestController
public class DayOneController {
	
	@Autowired
	private DayOneService dayOneService;
	
	@GetMapping("/api-D1-P1")
	public Integer partOneGetExample() {
		return this.dayOneService.solvePartOneTask(DayOneService.DAY_EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-D1-P1")
	public Integer partOneSolve(@RequestBody String input) {
		return this.dayOneService.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-D1-P2")
	public Integer partTwoGetExample() {
		return this.dayOneService.solvePartTwoTask(DayOneService.DAY_EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-D1-P2")
	public Integer partTwoSolve(@RequestBody String input) {
		return this.dayOneService.solvePartTwoTask(input).getAnswer();
	}
	
}
