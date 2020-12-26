package pl.lw.adventofcode.twentytwenty.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AdventOfCodeUtils {
	
	public List<String> getListFromStringPuzzleInput(String input) {
		List<String> puzzleInput = new ArrayList<>();
		for (String puzzleLine : input.split("\\r?\\n")) {
			puzzleInput.add(puzzleLine.trim());
		}
		return puzzleInput;
	}
}
