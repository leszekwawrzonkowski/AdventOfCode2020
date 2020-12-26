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
	
	@GetMapping("/day-one-part-one")
	public Integer partOneGetExample() {
		return this.dayOneService.solvePartOneTask("1721\n979\n366\n299\n675\n1456").getAnswer();
	}
	
	@PostMapping("/day-one-part-one")
	public Integer partOneSolve(@RequestBody String input) {
		return this.dayOneService.solvePartOneTask(input).getAnswer();
	}
	
	@GetMapping("/day-one-part-two")
	public Integer partTwoGetExample() {
		return this.dayOneService.solvePartTwoTask("1721\n979\n366\n299\n675\n1456").getAnswer();
	}
	
	@PostMapping("/day-one-part-two")
	public Integer partTwoSolve(@RequestBody String input) {
		return this.dayOneService.solvePartTwoTask(input).getAnswer();
	}
	
}
