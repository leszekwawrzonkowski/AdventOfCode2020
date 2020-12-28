package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayOneTask;
import pl.lw.adventofcode.twentytwenty.util.AdventOfCodeUtils;

@Service
public class DayOneService {
	
	public static final String DAY_NAME = "Day 1";
	public static final String DAY_ID_SUFFIX = "D1";
	public static final String DAY_EXAMPLE_INPUT = "1721\n979\n366\n299\n675\n1456";
	public static final String DAY_PUZZLE_PAGE_URL = "https://adventofcode.com/2020/day/1";
	public static final String DAY_INPUT_PAGE_URL = "https://adventofcode.com/2020/day/1/input";
	
	public static final Integer EXPECTED_SUM = 2020;
	public static final Integer PART_ONE_ELEMENTS_TO_SUM = 2;
	public static final Integer PART_TWO_ELEMENTS_TO_SUM = 3;
	
	Logger logger = LoggerFactory.getLogger(DayOneService.class);
	
	@Autowired
	private AdventOfCodeUtils adventOfCodeUtils;

	public DayOneTask solvePartOneTask(String input) {
		DayOneTask task = new DayOneTask();
		task.setPuzzleInput(adventOfCodeUtils.getListFromStringPuzzleInput(input));
		task.setAnswer(this.solvingTaskCore(task.getPuzzleInput(), DayOneService.EXPECTED_SUM, DayOneService.PART_ONE_ELEMENTS_TO_SUM, new ArrayList<>()));
		return task;
	}
	
	public DayOneTask solvePartTwoTask(String input) {
		DayOneTask task = new DayOneTask();
		task.setPuzzleInput(adventOfCodeUtils.getListFromStringPuzzleInput(input));
		task.setAnswer(this.solvingTaskCore(task.getPuzzleInput(), EXPECTED_SUM, DayOneService.PART_TWO_ELEMENTS_TO_SUM, new ArrayList<>()));
		return task;
	}
	
	private Integer solvingTaskCore(List<Integer> elementsToCheck, Integer expectedSum, Integer elementsToSum, List<Integer> candidates) {
		// have to check elements
		logger.trace("elementsToCheck : " + elementsToCheck);
		for (int i = 0; i < elementsToCheck.size(); i++) {
			//add an element to candidates
			candidates.add(elementsToCheck.get(i));
			logger.trace("candidates : " + candidates);
			// candidates limit achieved
			if (candidates.size() == elementsToSum) {
				// it's a solution
				if (this.sumElements(candidates).equals(expectedSum)) {
					logger.trace("Solution candidates : " + candidates);
					return this.multiplyElements(candidates);
				}
				// it's not a solution
				logger.trace("it's not a solution, removing from candidates : "+elementsToCheck.get(i));
				candidates.remove(elementsToCheck.get(i));
				continue;
			}
			//there is no place to go further
			if (i + 1 == elementsToCheck.size()) {
				logger.trace("no place to go further, removing from candidates : "+elementsToCheck.get(i));
				candidates.remove(elementsToCheck.get(i));
				return null;
			}
			//prepare new list without previous elements
			List<Integer> elementsToCheckFurther = new ArrayList<>();
			for (int j = i + 1; j < elementsToCheck.size(); j++) elementsToCheckFurther.add(elementsToCheck.get(j));
			//look for next candidates further
			Integer result = solvingTaskCore(elementsToCheckFurther, expectedSum, elementsToSum, candidates);
			//check if result found
			if (result != null) return result;
			// remove because it wasn't a good candidate
			logger.trace("removing from candidates : "+elementsToCheck.get(i));
			candidates.remove(elementsToCheck.get(i));
		}
		
		return null;
	}
	
	private Integer sumElements(List<Integer> elements) {
		return elements.stream().reduce(0, (a, b) -> a + b);
	}
	
	private Integer multiplyElements(List<Integer> elements) {
		return elements.stream().reduce(1, (a, b) -> a * b);
	}
	
}
