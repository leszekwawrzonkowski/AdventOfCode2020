package pl.lw.adventofcode.twentytwenty.domain;

import java.util.ArrayList;

public class DayTaskWithStrings extends DayTask<String> {
	
	@Override
	public void setPuzzleInput(String puzzleInput) {
		this.puzzleInput = new ArrayList<String>();
		for (String puzzleLine : puzzleInput.split(PUZZLE_LINE_SEPARATOR)) this.puzzleInput.add(String.valueOf(puzzleLine.trim()));
	}
	
}