package pl.lw.adventofcode.twentytwenty.service;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayTwoService {

	public static final String NAME = "Day 2";
	public static final String ID = "D2";
	public static final String EXAMPLE_INPUT = ""
			+ "1-3 a: abcde\n"
			+ "1-3 b: cdefg\n"
			+ "2-9 c: ccccccccc";
	public static final String PUZZLE_PAGE_URL = "https://adventofcode.com/2020/day/2";
	public static final String INPUT_PAGE_URL = "https://adventofcode.com/2020/day/2/input";

	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		task.setAnswer(task.getPuzzleInput().stream().filter(DayTwoService::isPasswordMatchesPartOneRules).count());
		return task;
	}
	
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		task.setAnswer(task.getPuzzleInput().stream().filter(DayTwoService::isPasswordMatchesPartTwoRules).count());
		return task;
	}
	
	public static boolean isPasswordMatchesPartOneRules(String passInput) {
		PasswordRules passRules = new PasswordRules(passInput);
		Long count = passRules.pass.chars().filter(ch -> ch == passRules.letter).count();
		return count >= passRules.firstNumber && count <= passRules.secondNumber;
	}
	
	public static boolean isPasswordMatchesPartTwoRules(String passInput) {
		PasswordRules passRules = new PasswordRules(passInput);
		return passRules.pass.charAt(passRules.firstNumber-1) == passRules.letter ^ passRules.pass.charAt(passRules.secondNumber-1) == passRules.letter;
	}
	
	private static class PasswordRules {
		private Integer firstNumber;
		private Integer secondNumber;
		private char letter;
		private String pass;
		
		public PasswordRules(String passInput) {
			String[] split1 = passInput.split(" ");
			String[] split2 = split1[0].split("-");
			firstNumber = Integer.valueOf(split2[0]);
			secondNumber = Integer.valueOf(split2[1]);
			letter = split1[1].charAt(0);
			pass = split1[2].trim();
		}
	}
}
