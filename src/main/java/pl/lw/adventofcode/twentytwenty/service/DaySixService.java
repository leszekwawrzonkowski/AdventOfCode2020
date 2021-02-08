package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DaySixService {
	
	public static final String ID = "D6";
	public static final String EXAMPLE_INPUT = ""
			+ "abc\n"
			+ "\n"
			+ "a\n"
			+ "b\n"
			+ "c\n"
			+ "\n"
			+ "ab\n"
			+ "ac\n"
			+ "\n"
			+ "a\n"
			+ "a\n"
			+ "a\n"
			+ "a\n"
			+ "\n"
			+ "b";
	
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}
	
	/** AoC2020 D6T1 task description: 
	 * For each group, count the number of questions to which anyone answered "yes". 
	 * What is the sum of those counts?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<PersonsGroup> personsGroups = preparePersonsGroupList(task.getPuzzleInput());
			task.setAnswer(personsGroups.stream()
					.mapToLong(PersonsGroup::countAnyoneAnswers)
					.sum());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D6T2 task description: 
	 * For each group, count the number of questions to which everyone answered "yes". 
	 * What is the sum of those counts?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<PersonsGroup> personsGroups = preparePersonsGroupList(task.getPuzzleInput());
			task.setAnswer(personsGroups.stream()
					.mapToLong(PersonsGroup::countEveryoneAnswers)
					.sum());
		} catch(Exception e) {}
		return task;
	}
	
	private List<PersonsGroup> preparePersonsGroupList(List<String> puzzleInput) {
		List<PersonsGroup> personsGroups = new ArrayList<>();
		personsGroups.add(new PersonsGroup());
		for (String puzzleLine : puzzleInput) {
			// Each group's answers are separated by a blank line
			if (puzzleLine.equals("")) {
				personsGroups.add(new PersonsGroup());
				continue;
			}
			personsGroups.get(personsGroups.size()-1).addPersonAnswers(puzzleLine);
		}
		return personsGroups;
	}
	
	private class PersonsGroup {
		private List<String> personsAnswers = new ArrayList<>();
		
		public void addPersonAnswers(String personAnswers) {
			personsAnswers.add(personAnswers);
		}
		
		/** Counts questions to which anyone answered "yes" (count unique answers).
		 * 
		 * @return counter
		 */
		public Integer countAnyoneAnswers() {
			// from http://bytepadding.com/java/java-core/java-8-get-all-unique-characters-from-list-of-string-using-flatmap/
			return personsAnswers.stream()
					.map(c -> c.split(""))
					.flatMap(Arrays::stream)
					.distinct()
					.collect(Collectors.toList())
					.size();
		}
		
		/** Counts questions to which everyone answered "yes" (count same answers).
		 * 
		 * @return counter
		 */
		public Integer countEveryoneAnswers() {
			List<Character> sameChars = null;
			for (String personAnswers : personsAnswers) {
				List<Character> chars = personAnswers.chars()
				.mapToObj(c -> (char) c)
				.collect(Collectors.toList());
				if (sameChars == null) {
					sameChars = chars;
					continue;
				}
				sameChars.retainAll(chars);
			}
			return sameChars.size();
		}
		
	}
}
