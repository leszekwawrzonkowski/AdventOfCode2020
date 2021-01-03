package pl.lw.adventofcode.twentytwenty.domain;

import java.util.List;

public abstract class DayTask<T> {
	
	public static final String PUZZLE_LINE_SEPARATOR = "\\r?\\n";
	
	protected List<T> puzzleInput;
	protected Long answer;

	public abstract void setPuzzleInput(String puzzleInput);
	
	public List<T> getPuzzleInput() {
		return puzzleInput;
	}

	public Long getAnswer() {
		return answer;
	}

	public void setAnswer(Long answer) {
		this.answer = answer;
	}
}
