package pl.lw.adventofcode.twentytwenty.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.service.DayEightService;
import pl.lw.adventofcode.twentytwenty.service.DayFiveService;
import pl.lw.adventofcode.twentytwenty.service.DayFourService;
import pl.lw.adventofcode.twentytwenty.service.DayNineService;
import pl.lw.adventofcode.twentytwenty.service.DayOneService;
import pl.lw.adventofcode.twentytwenty.service.DaySevenService;
import pl.lw.adventofcode.twentytwenty.service.DaySixService;
import pl.lw.adventofcode.twentytwenty.service.DayThreeService;
import pl.lw.adventofcode.twentytwenty.service.DayTwoService;

@Controller
public class DaysWebPageController {
	
	private List<DayInfo> days = new ArrayList<> (Arrays.asList(
			DayOneService.getDayInfo(),
			DayTwoService.getDayInfo(),
			DayThreeService.getDayInfo(),
			DayFourService.getDayInfo(),
			DayFiveService.getDayInfo(),
			DaySixService.getDayInfo(),
			DaySevenService.getDayInfo(),
			DayEightService.getDayInfo(),
			DayNineService.getDayInfo()
			));
	
	@GetMapping("/")
	public String daysWebPage(Model model) {
		model.addAttribute("days", days);
		return "days-web-page";
	}

}
