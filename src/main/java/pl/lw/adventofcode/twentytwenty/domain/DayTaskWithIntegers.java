package pl.lw.adventofcode.twentytwenty.domain;

import java.util.ArrayList;

public class DayTaskWithIntegers extends DayTask<Integer> {
	
	@Override
	public void setPuzzleInput(String puzzleInput) {
		this.puzzleInput = new ArrayList<Integer>();
		for (String puzzleLine : puzzleInput.split(PUZZLE_LINE_SEPARATOR)) this.puzzleInput.add(Integer.valueOf(puzzleLine.trim()));
	}
	
}
