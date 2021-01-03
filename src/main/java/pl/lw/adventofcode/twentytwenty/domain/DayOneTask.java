package pl.lw.adventofcode.twentytwenty.domain;

import java.util.ArrayList;
import java.util.List;

public class DayOneTask implements Task<Integer> {
	
	private List<Integer> puzzleInput;
	private Integer answer;
	
	public DayOneTask() {
		super();
	}

	@Override
	public void setPuzzleInput(List<String> puzzleInput) {
		this.puzzleInput = new ArrayList<Integer>();
		for (String puzzleLine : puzzleInput) this.puzzleInput.add(Integer.valueOf(puzzleLine));
	}
	
	@Override
	public List<Integer> getPuzzleInput() {
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
