package pl.lw.adventofcode.twentytwenty.domain;

import java.util.List;

public interface Task<T> {
	
	public void setPuzzleInput(List<String> puzzleInput);
	
	public List<T> getPuzzleInput();
	
	public void setAnswer(Integer answer);
	
	public Integer getAnswer();
	
}
