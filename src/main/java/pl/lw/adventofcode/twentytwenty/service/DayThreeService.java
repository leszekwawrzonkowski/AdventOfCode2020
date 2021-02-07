package pl.lw.adventofcode.twentytwenty.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayThreeService {
	
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
	
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}

	/** AoC2020 D3T1 task description: 
	 * Starting at the top-left corner of your map and 
	 * following a slope of right 3 and down 1, how many trees would you encounter?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			task.setAnswer((long)countEncounteredTrees(task.getPuzzleInput(), 3, 1));
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D3T2 task description:
	 * Determine the number of trees you would encounter if, 
	 * for each of the following slopes, you start at the top-left corner and 
	 * traverse the map all the way to the bottom:
	 * Right 1, down 1.
	 * Right 3, down 1.
	 * Right 5, down 1.
	 * Right 7, down 1.
	 * Right 1, down 2.
	 * What do you get if you multiply together the number of trees 
	 * encountered on each of the listed slopes?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
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
		} catch(Exception e) {}
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
