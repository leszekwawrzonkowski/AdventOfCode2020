package pl.lw.adventofcode.twentytwenty.domain;

public class Day {
	
	private String name;
	private String id;
	private String exampleInput;
	private String puzzlePageUrl;
	private String inputPageUrl;
	
	
	public Day(String name, String id, String exampleInput, String puzzlePageUrl, String inputPageUrl) {
		super();
		this.name = name;
		this.id = id;
		this.exampleInput = exampleInput;
		this.puzzlePageUrl = puzzlePageUrl;
		this.inputPageUrl = inputPageUrl;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getExampleInput() {
		return exampleInput;
	}
	
	public void setExampleInput(String exampleInput) {
		this.exampleInput = exampleInput;
	}
	
	public String getPuzzlePageUrl() {
		return puzzlePageUrl;
	}
	
	public void setPuzzlePageUrl(String puzzlePageUrl) {
		this.puzzlePageUrl = puzzlePageUrl;
	}
	
	public String getInputPageUrl() {
		return inputPageUrl;
	}
	
	public void setInputPageUrl(String inputPageUrl) {
		this.inputPageUrl = inputPageUrl;
	}
	
	

}
