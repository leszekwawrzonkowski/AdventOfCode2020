package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DaySevenService {

	public static final String ID = "D7";
	public static final String EXAMPLE_INPUT = ""
			+ "light red bags contain 1 bright white bag, 2 muted yellow bags.\n"
			+ "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n"
			+ "bright white bags contain 1 shiny gold bag.\n"
			+ "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n"
			+ "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n"
			+ "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n"
			+ "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n"
			+ "faded blue bags contain no other bags.\n"
			+ "dotted black bags contain no other bags.\n";
	
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}
	
	/** AoC2020 D7T1 task description: 
	 * How many bag colors can eventually contain at least one 'shiny gold' bag? 
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<BagRules> bagsRules = prepareBagsRulesList(task.getPuzzleInput());
;			task.setAnswer((long)fillListOfBagsForColor("shiny gold", new ArrayList<>(), bagsRules).size());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D7T2 task description: 
	 * How many individual bags are required inside your single 'shiny gold' bag?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<BagRules> bagsRules = prepareBagsRulesList(task.getPuzzleInput());
			task.setAnswer(countIndividualBagsRequired("shiny gold", bagsRules) - 1); // "-1" because the first bag is not counted in the task
		} catch(Exception e) {}
		return task;
	}
	
	private List<BagRules> prepareBagsRulesList(List<String> puzzleInput) {
		List<BagRules> bagsRules = new ArrayList<>();
		for (String puzzleLine : puzzleInput) {
			bagsRules.add(new BagRules(puzzleLine));
		}
		return bagsRules;
	}
	
	private List<String> fillListOfBagsForColor(String color, List<String> bags, List<BagRules> bagsRules) {
		List<BagRules> matchedBagsRules = bagsRules.stream()
				.filter(b -> b.canContainBag(color))
				.collect(Collectors.toList());
		for (BagRules foundBagRules : matchedBagsRules) {
			if (!bags.contains(foundBagRules.color)) bags.add(new String(foundBagRules.color));
			fillListOfBagsForColor(foundBagRules.color, bags, bagsRules);
		}
		return bags;
	}
	
	private Long countIndividualBagsRequired(String color, List<BagRules> bagsRules) {
		Long result = Long.valueOf(1);
		BagRules bagRules = bagsRules.stream()
				.filter(b -> b.getColor().equals(color))
				.collect(Collectors.toList())
				.get(0);
		for (String bagColor : bagRules.containedBags.keySet()) {
			result += bagRules.containedBags.get(bagColor) * countIndividualBagsRequired(bagColor, bagsRules);
		}
		return result;
	}
	
	private class BagRules {
		
		private final String color;
		private final Map<String, Integer> containedBags = new HashMap<>();
		
		public BagRules(String bagRules) {
			String[] el = bagRules.split(" bags contain ");
			color = el[0];
			if (el[1].equals("no other bags.")) return;
			String[] bagsInBag = el[1].substring(0, el[1].length()-1).split(", ");
			for (String bagInBag : bagsInBag) {
				Integer bagCount = Integer.valueOf(bagInBag.substring(0, bagInBag.indexOf(" ")));
				String bagColor = bagInBag.substring(bagInBag.indexOf(" ")+1, bagInBag.lastIndexOf(" "));
				containedBags.put(bagColor, bagCount);
			}
		}
		
		public String getColor() {
			return color;
		}
		
		public boolean canContainBag(String bagColor) {
			// System.out.println("Matching color '" + bagColor + "' to bag rules : "+this.toString());
			if (containedBags.containsKey(bagColor)) {
				// System.out.println("Match found!");
				return true;
			}
			return false;
		}

		@Override
		public String toString() {
			return "BagRules [color=" + color + ", containedBags=" + containedBags + "]";
		}
	}
}
