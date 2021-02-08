package pl.lw.adventofcode.twentytwenty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import pl.lw.adventofcode.twentytwenty.service.DayFiveService;
import pl.lw.adventofcode.twentytwenty.service.DayFourService;
import pl.lw.adventofcode.twentytwenty.service.DayOneService;
import pl.lw.adventofcode.twentytwenty.service.DaySevenService;
import pl.lw.adventofcode.twentytwenty.service.DaySixService;
import pl.lw.adventofcode.twentytwenty.service.DayThreeService;
import pl.lw.adventofcode.twentytwenty.service.DayTwoService;

@RestController
public class DaysWebApiController {

	@Autowired
	private DayOneService d1;
	@Autowired
	private DayTwoService d2;
	@Autowired
	private DayThreeService d3;
	@Autowired
	private DayFourService d4;
	@Autowired
	private DayFiveService d5;
	@Autowired
	private DaySixService d6;
	@Autowired
	private DaySevenService d7;
	
	@PostMapping("/api-"+DayOneService.ID+"-P1")
	public Long d1P1Solve(@RequestBody String input) {
		return d1.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayOneService.ID+"-P2")
	public Long d1P2Solve(@RequestBody String input) {
		return d1.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayTwoService.ID+"-P1")
	public Long d2P1Solve(@RequestBody String input) {
		return d2.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayTwoService.ID+"-P2")
	public Long d2P2Solve(@RequestBody String input) {
		return d2.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P1")
	public Long d3P1Solve(@RequestBody String input) {
		return d3.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayThreeService.ID+"-P2")
	public Long d3P2Solve(@RequestBody String input) {
		return d3.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayFourService.ID+"-P1")
	public Long d4P1Solve(@RequestBody String input) {
		return d4.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayFourService.ID+"-P2")
	public Long d4P2Solve(@RequestBody String input) {
		return d4.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayFiveService.ID+"-P1")
	public Long d5P1Solve(@RequestBody String input) {
		return d5.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DayFiveService.ID+"-P2")
	public Long d5P2Solve(@RequestBody String input) {
		return d5.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DaySixService.ID+"-P1")
	public Long d6P1Solve(@RequestBody String input) {
		return d6.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DaySixService.ID+"-P2")
	public Long d6P2Solve(@RequestBody String input) {
		return d6.solvePartTwoTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DaySevenService.ID+"-P1")
	public Long d7P1Solve(@RequestBody String input) {
		return d7.solvePartOneTask(input).getAnswer();
	}
	
	@PostMapping("/api-"+DaySevenService.ID+"-P2")
	public Long d7P2Solve(@RequestBody String input) {
		return d7.solvePartTwoTask(input).getAnswer();
	}
}
