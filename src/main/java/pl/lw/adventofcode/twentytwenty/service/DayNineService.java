package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayNineService {

	public static final String ID = "D9";
	public static final String EXAMPLE_INPUT = "#preamble-length=5\n"
			+ "35\n"
			+ "20\n"
			+ "15\n"
			+ "25\n"
			+ "47\n"
			+ "40\n"
			+ "62\n"
			+ "55\n"
			+ "65\n"
			+ "95\n"
			+ "102\n"
			+ "117\n"
			+ "150\n"
			+ "182\n"
			+ "127\n"
			+ "219\n"
			+ "299\n"
			+ "277\n"
			+ "309\n"
			+ "576\n"
			+ "";
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}
	
	/** AoC2020 D9T1 task description: 
	 * To find the first number in the list (after the preamble) which is not the sum of two of the 'X' numbers before it.
	 * What is the first number that does not have this property? 
	 * 'X' depends on the preamble length - default is 25.
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			Integer preambleLength = getAndRemovePreambleLength(task.getPuzzleInput());
			List<Long> numbers = changeInputListToLong(task.getPuzzleInput());
			Long firstNumber = findTheFirstNumberWhichIsNotTheSumOfAnyTwoOnTheList(preambleLength, numbers);
			task.setAnswer(firstNumber);
		} catch(Exception e) {e.printStackTrace();}
		return task;
	}
	
	/** AoC2020 D9T2 task description: 
	 * You must find a contiguous set of at least two numbers in your list which sum to the invalid number from step 1.
	 * To find the encryption weakness, add together the smallest and largest number in this contiguous range;
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			Integer preambleLength = getAndRemovePreambleLength(task.getPuzzleInput());
			List<Long> numbers = changeInputListToLong(task.getPuzzleInput());
			Long firstNumber = findTheFirstNumberWhichIsNotTheSumOfAnyTwoOnTheList(preambleLength, numbers);
			for (int i=0; i<numbers.size(); i++) {
				List<Long> numbersToSum = new ArrayList<>();
				numbersToSum.add(numbers.get(i));
				for (int j=i+1; j<numbers.size(); j++ ) {
					numbersToSum.add(numbers.get(j));
					int compResult = firstNumber.compareTo(numbersToSum.stream()
							.reduce(Long.valueOf(0), (a, b) -> a + b));
					
					// sum of elements is the same as found number
					if (compResult == 0) {
						long smallestNumber = numbersToSum.stream()
								.mapToLong(v -> v)
								.min()
								.orElseThrow(NoSuchElementException::new);
						long largestNumber = numbersToSum.stream()
								.mapToLong(v -> v)
								.max()
								.orElseThrow(NoSuchElementException::new);
						task.setAnswer(smallestNumber + largestNumber);
						return task;
					}
					// sum of elements is bigger than found number
					else if (compResult < 0) break;
				}
			}
			
		} catch(Exception e) {}
		return task;
	}
	
	private Integer getAndRemovePreambleLength(List<String> puzzleInput) {
		// default preamble length is 25
		Integer preambleLength = Integer.valueOf(25);
		// preamble length in the first line (workaround for an example)
		if (puzzleInput.get(0).startsWith("#preamble-length")) {
			preambleLength = Integer.valueOf(puzzleInput.get(0).split("=")[1]);
			puzzleInput.remove(0);
		}
		return preambleLength;
	}
	
	private List<Long> changeInputListToLong(List<String> puzzleInput) {
		List<Long> numbers = new ArrayList<>();
		for (String s : puzzleInput) numbers.add(Long.valueOf(s));
		return numbers;
	}
	
	private Long findTheFirstNumberWhichIsNotTheSumOfAnyTwoOnTheList(Integer preambleLength, List<Long> puzzleInput) {
		for (int i = preambleLength; i<puzzleInput.size(); i++) {
			Long sumToFind = Long.valueOf(puzzleInput.get(i));
			List<Long> numbersToCheck = new ArrayList<>();
			for (Long l : puzzleInput.subList(i-preambleLength, i)) numbersToCheck.add(l);
			if (!isSumOccursForAnyTwoOnTheList(sumToFind, numbersToCheck)) return sumToFind;
		}
		return null;
	}
	
	private boolean isSumOccursForAnyTwoOnTheList(Long sumToFind, List<Long> numbersToCheck) {
		// simple loop in the loop because only two level of elements to check
		for (int i=0; i<numbersToCheck.size(); i++ ) {
			for (int j=i+1; j<numbersToCheck.size(); j++ ) {
				if (numbersToCheck.get(i).longValue() + numbersToCheck.get(j).longValue() == sumToFind.longValue()) return true;
			}
		}
		return false;
	}
}
