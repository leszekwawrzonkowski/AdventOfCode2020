package pl.lw.adventofcode.twentytwenty.service;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayTwoService {
	
	public static final String ID = "D2";
	public static final String EXAMPLE_INPUT = ""
			+ "1-3 a: abcde\n"
			+ "1-3 b: cdefg\n"
			+ "2-9 c: ccccccccc";
	
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}

	/** AoC2020 D2T1 task description: 
	 * How many passwords are valid according to their policies?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			task.setAnswer(task.getPuzzleInput().stream().filter(DayTwoService::isPasswordMatchesPartOneRules).count());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D2T2 task description: 
	 * How many passwords are valid according to the new interpretation of the policies?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			task.setAnswer(task.getPuzzleInput().stream().filter(DayTwoService::isPasswordMatchesPartTwoRules).count());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D2T1 password rules: 
	 * The password policy indicates the lowest and 
	 * highest number of times a given letter must appear for the password to be valid. 
	 * For example, '1-3 a' means that the password must contain 'a' at least '1' time and at most '3' times.
	 * 
	 * @param passInput password input
	 * @return is password matched the rules
	 */
	public static boolean isPasswordMatchesPartOneRules(String passInput) {
		PasswordRules passRules = new PasswordRules(passInput);
		Long count = passRules.pass.chars().filter(ch -> ch == passRules.letter).count();
		return count >= passRules.firstNumber && count <= passRules.secondNumber;
	}
	
	/** AoC2020 D2T2 password rules: 
	 * The password policy actually describes two positions in the password, 
	 * where 1 means the first character, 2 means the second character, and so on. 
	 * Exactly one of these positions must contain the given letter. 
	 * Other occurrences of the letter are irrelevant for the purposes of policy enforcement.
	 * 
	 * @param passInput password input
	 * @return is password matched the rules
	 */
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
