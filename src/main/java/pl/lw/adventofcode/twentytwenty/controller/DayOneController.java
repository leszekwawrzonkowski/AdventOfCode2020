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
	
	@GetMapping("/api-"+DayOneService.ID+"-P1")
	public Integer partOneGetExample() {
		return dayOneService.solvePartOneTask(DayOneService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayOneService.ID+"-P1")
	public Integer partOneSolve(@RequestBody String input) {
		return dayOneService.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayOneService.ID+"-P2")
	public Integer partTwoGetExample() {
		return dayOneService.solvePartTwoTask(DayOneService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayOneService.ID+"-P2")
	public Integer partTwoSolve(@RequestBody String input) {
		return dayOneService.solvePartTwoTask(input).getAnswer();
	}
	
}
