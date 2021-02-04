package pl.lw.adventofcode.twentytwenty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayThreeService {
	
	public static final String NAME = "Day 3";
	public static final String ID = "D3";
	public static final String EXAMPLE_INPUT = ""
			+ "..##.......\n"
			+ "#...#...#..\n"
			+ ".#....#..#.\n"
			+ "..#.#...#.#\n"
			+ ".#...##..#.\n"
			+ "..#.##.....\n"
			+ ".#.#.#....#\n"
			+ ".#........#\n"
			+ "#.##...#...\n"
			+ "#...##....#\n"
			+ ".#..#...#.#";
	public static final String PUZZLE_PAGE_URL = "https://adventofcode.com/2020/day/3";
	public static final String INPUT_PAGE_URL = "https://adventofcode.com/2020/day/3/input";

	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		task.setAnswer((long)countEncounteredTrees(task.getPuzzleInput(), 3, 1));
		return task;
	}
	
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		Long answer = Long.valueOf(1);
		// Right 1, down 1
		answer = answer * countEncounteredTrees(task.getPuzzleInput(), 1, 1);
		// Right 3, down 1
		answer = answer * countEncounteredTrees(task.getPuzzleInput(), 3, 1);
		// Right 5, down 1
		answer = answer * countEncounteredTrees(task.getPuzzleInput(), 5, 1);
		// Right 7, down 1
		answer = answer * countEncounteredTrees(task.getPuzzleInput(), 7, 1);
		// Right 1, down 2
		answer = answer * countEncounteredTrees(task.getPuzzleInput(), 1, 2);
		task.setAnswer(answer);
		return task;
	}
	
	private Integer countEncounteredTrees(List<String> elementsToCheck, Integer tobogganRightMoves, Integer tobogganDownMoves) {
		Integer answer = 0;
		char tree = '#';
		for (int i = tobogganDownMoves; i<elementsToCheck.size(); i = i + tobogganDownMoves) {
			String puzzleLine = elementsToCheck.get(i);
			if (puzzleLine.charAt(((int)(i / tobogganDownMoves) * tobogganRightMoves) % puzzleLine.length()) == tree) answer++;
		}
		return answer;
	}

}
