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
	private DayThreeService dayThreeService;
	
	@GetMapping("/api-"+DayThreeService.ID+"-P1")
	public Long partOneGetExample() {
		return dayThreeService.solvePartOneTask(DayThreeService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P1")
	public Long partOneSolve(@RequestBody String input) {
		return dayThreeService.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/api-"+DayThreeService.ID+"-P2")
	public Long partTwoGetExample() {
		return dayThreeService.solvePartTwoTask(DayThreeService.EXAMPLE_INPUT).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P2")
	public Long partTwoSolve(@RequestBody String input) {
		return dayThreeService.solvePartTwoTask(input).getAnswer();
	}
}
