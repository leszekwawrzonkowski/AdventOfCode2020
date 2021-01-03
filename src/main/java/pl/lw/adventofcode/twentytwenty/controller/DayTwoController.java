package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayTwoService;

@RestController
public class DayTwoController {
	
	@Autowired
	private DayTwoService dayTwoService;
	
	@GetMapping("/api-"+DayTwoService.ID+"-P1")
	public Integer partOneGetExample() {
		return dayTwoService.solvePartOneTask(DayTwoService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayTwoService.ID+"-P1")
	public Integer partOneSolve(@RequestBody String input) {
		return dayTwoService.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayTwoService.ID+"-P2")
	public Integer partTwoGetExample() {
		return dayTwoService.solvePartTwoTask(DayTwoService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayTwoService.ID+"-P2")
	public Integer partTwoSolve(@RequestBody String input) {
		return dayTwoService.solvePartTwoTask(input).getAnswer();
	}

}
