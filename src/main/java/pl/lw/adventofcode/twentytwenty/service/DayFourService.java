package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayFourService {
	public static final String NAME = "Day 4";
	public static final String ID = "D4";
	public static final String EXAMPLE_INPUT = ""
			+ "ecl:gry pid:860033327 eyr:2020 hcl:#fffffd\n"
			+ "byr:1937 iyr:2017 cid:147 hgt:183cm\n"
			+ "\n"
			+ "iyr:2013 ecl:amb cid:350 eyr:2023 pid:028048884\n"
			+ "hcl:#cfa07d byr:1929\n"
			+ "\n"
			+ "hcl:#ae17e1 iyr:2013\n"
			+ "eyr:2024\n"
			+ "ecl:brn pid:760753108 byr:1931\n"
			+ "hgt:179cm\n"
			+ "\n"
			+ "hcl:#cfa07d eyr:2025 pid:166559648\n"
			+ "iyr:2011 ecl:brn hgt:59in";
	public static final String PUZZLE_PAGE_URL = "https://adventofcode.com/2020/day/4";
	public static final String INPUT_PAGE_URL = "https://adventofcode.com/2020/day/4/input";

	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		List<Passport> passports = preparePassportsList(task.getPuzzleInput());
		task.setAnswer(passports.stream().filter(DayFourService::isPassportValidPartOne).count());
		return task;
	}
	
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		task.setPuzzleInput(input);
		List<Passport> passports = preparePassportsList(task.getPuzzleInput());
		task.setAnswer(passports.stream().filter(DayFourService::isPassportValidPartTwo).count());
		return task;
	}
	
	private List<Passport> preparePassportsList(List<String> puzzleInput) {
		List<Passport> passports = new ArrayList<>();
		passports.add(new Passport());
		for (String puzzleLine : puzzleInput) {
			// Passports are separated by blank lines
			if(puzzleLine.equals("")) {
				passports.add(new Passport());
				continue;
			}
			Pattern.compile(" ").splitAsStream(puzzleLine).forEach(passports.get(passports.size()-1)::addField);
		}
		return passports;
	}
	
	public static boolean isPassportValidPartOne(Passport p) {
		return p.isValidPartOne();
	}
	
	public static boolean isPassportValidPartTwo(Passport p) {
		return p.isValidPartTwo();
	}
	
	private class Passport {
		Map<String, String> fields = new HashMap<>();
		
		public void addField(String field) {
			String[] keyValue = field.split(":");
			fields.put(keyValue[0], keyValue[1]);
		}
		
		public boolean isValidPartOne() {
			return fields.containsKey("byr") && fields.containsKey("iyr") && fields.containsKey("eyr") && fields.containsKey("hgt")
					&& fields.containsKey("hcl") && fields.containsKey("ecl") && fields.containsKey("pid");
		}
		
		private boolean isFieldInRange(String fieldName, Integer fromInclusive, Integer toInclusive) {
			try {
				Integer val = Integer.valueOf(fields.get(fieldName));
				return fromInclusive <= val && val <= toInclusive;
			}
			catch(Exception e) {}
			return false;
		}
		
		private boolean isBirthYearValid() {
			return isFieldInRange("byr", 1920, 2002);
		}
		
		private boolean isIssueYearValid() {
			return isFieldInRange("iyr", 2010, 2020);
		}
		
		private boolean isExpirationYearValid() {
			return isFieldInRange("eyr", 2020, 2030);
		}
		
		private boolean isHeightValid() {
			try {
				String fVal = fields.get("hgt");
				Integer val = Integer.valueOf(fVal.substring(0, fVal.length()-2));
				if(fVal.endsWith("cm")) return 150 <= val && val <= 193;
				else if(fVal.endsWith("in")) return 59 <= val && val <= 76;
			}
			catch(Exception e) {}
			return false;
		}
		
		private boolean isHairColorValid() {
			try {
				String val = fields.get("hcl");
				return val.startsWith("#") && val.substring(1).matches("[0-9a-f]{6}");
			}
			catch(Exception e) {}
			return false;
		}
		
		private boolean isEyeColorValid() {
			try {
				return fields.get("ecl").matches("(amb|blu|brn|gry|grn|hzl|oth)");
			}
			catch(Exception e) {}
			return false;
		}
		
		private boolean isPassportIdValid() {
			try {
				return fields.get("pid").matches("[0-9]{9}");
			}
			catch(Exception e) {}
			return false;
		}
		
		public boolean isValidPartTwo() {
			return isValidPartOne() && isBirthYearValid() && isIssueYearValid() && isExpirationYearValid() && isHeightValid()
					&& isHairColorValid() && isEyeColorValid() && isPassportIdValid();
		}
	}
	

}
