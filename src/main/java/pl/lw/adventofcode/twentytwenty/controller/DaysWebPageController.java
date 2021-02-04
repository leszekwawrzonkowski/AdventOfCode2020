package pl.lw.adventofcode.twentytwenty.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.lw.adventofcode.twentytwenty.domain.Day;
import pl.lw.adventofcode.twentytwenty.service.DayFourService;
import pl.lw.adventofcode.twentytwenty.service.DayOneService;
import pl.lw.adventofcode.twentytwenty.service.DayThreeService;
import pl.lw.adventofcode.twentytwenty.service.DayTwoService;

@Controller
public class DaysWebPageController {
	
	private List<Day> days = new ArrayList<> (Arrays.asList(
			new Day(DayOneService.NAME, DayOneService.ID, DayOneService.EXAMPLE_INPUT, DayOneService.PUZZLE_PAGE_URL, DayOneService.INPUT_PAGE_URL),
			new Day(DayTwoService.NAME, DayTwoService.ID, DayTwoService.EXAMPLE_INPUT, DayTwoService.PUZZLE_PAGE_URL, DayTwoService.INPUT_PAGE_URL),
			new Day(DayThreeService.NAME, DayThreeService.ID, DayThreeService.EXAMPLE_INPUT, DayThreeService.PUZZLE_PAGE_URL, DayThreeService.INPUT_PAGE_URL),
			new Day(DayFourService.NAME, DayFourService.ID, DayFourService.EXAMPLE_INPUT, DayFourService.PUZZLE_PAGE_URL, DayFourService.INPUT_PAGE_URL)
			));
	
	@GetMapping("/")
	public String daysWebPage(Model model) {
		model.addAttribute("days", days);
		return "days-web-page";
	}

}
