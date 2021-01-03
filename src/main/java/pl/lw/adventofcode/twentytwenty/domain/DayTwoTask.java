package pl.lw.adventofcode.twentytwenty.domain;

import java.util.ArrayList;
import java.util.List;

public class DayTwoTask implements Task<String> {
	
	private List<String> puzzleInput;
	private Integer answer;
	
	public DayTwoTask() {
		super();
	}

	@Override
	public void setPuzzleInput(List<String> puzzleInput) {
		this.puzzleInput = new ArrayList<String>();
		for (String puzzleLine : puzzleInput) this.puzzleInput.add(String.valueOf(puzzleLine));
	}
	
	@Override
	public List<String> getPuzzleInput() {
		return puzzleInput;
	}

	@Override
	public Integer getAnswer() {
		return answer;
	}

	@Override
	public void setAnswer(Integer answer) {
		this.answer = answer;
	}

}
