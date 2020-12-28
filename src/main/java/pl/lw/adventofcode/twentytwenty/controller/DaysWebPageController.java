package pl.lw.adventofcode.twentytwenty.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.lw.adventofcode.twentytwenty.domain.Day;
import pl.lw.adventofcode.twentytwenty.service.DayOneService;

@Controller
public class DaysWebPageController {
	
	private List<Day> days = new ArrayList<> (Arrays.asList(
			new Day(DayOneService.DAY_NAME, DayOneService.DAY_ID_SUFFIX, DayOneService.DAY_EXAMPLE_INPUT, DayOneService.DAY_PUZZLE_PAGE_URL, DayOneService.DAY_INPUT_PAGE_URL),
			new Day("Day 2", "D2", "TEST D2", "http://localhost:8080/", "http://localhost:8080/"),
			new Day("Day 3", "D3", "TEST D3", "http://localhost:8080/", "http://localhost:8080/")
			));
	
	@GetMapping("/")
	public String daysWebPage(Model model) {
		model.addAttribute("days", this.days);
		return "days-web-page";
	}

}
