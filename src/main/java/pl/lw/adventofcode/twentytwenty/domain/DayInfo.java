package pl.lw.adventofcode.twentytwenty.domain;

public class DayInfo {
	
	private static final String NAME_PREFIX = "Day ";
	private static final String PAGE_URL_PREFIX = "https://adventofcode.com/2020/day/";
	
	private final String name;
	private final String id;
	private final String exampleInput;
	private final String puzzlePageUrl;
	private final String inputPageUrl;
	
	public DayInfo(String id, String exampleInput) {
		this.name = NAME_PREFIX + id.substring(1);
		this.id = id;
		this.exampleInput = exampleInput;
		this.puzzlePageUrl = PAGE_URL_PREFIX + id.substring(1);
		this.inputPageUrl = PAGE_URL_PREFIX + id.substring(1) + "/input";
	}
	
	public String getName() {
		return name;
	}
	
	public String getId() {
		return id;
	}
	
	public String getExampleInput() {
		return exampleInput;
	}
	
	public String getPuzzlePageUrl() {
		return puzzlePageUrl;
	}
	
	public String getInputPageUrl() {
		return inputPageUrl;
	}
}
