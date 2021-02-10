package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayEightService {
	
	public static final String ID = "D8";
	public static final String EXAMPLE_INPUT = ""
			+ "nop +0\n"
			+ "acc +1\n"
			+ "jmp +4\n"
			+ "acc +3\n"
			+ "jmp -3\n"
			+ "acc -99\n"
			+ "acc +1\n"
			+ "jmp -4\n"
			+ "acc +6";
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}
	
	/** AoC2020 D8T1 task description: 
	 * Run your copy of the boot code. 
	 * Immediately before any instruction is executed a second time, what value is in the accumulator?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<Instruction> instructions = new ArrayList<>();
			for (String instructionLine : task.getPuzzleInput()) {
				instructions.add(new Instruction(instructionLine));
			}
			// program run
			ProgramResult programResult = runTheProgram(instructions);
			task.setAnswer((long)programResult.getAccumulator());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D8T2 task description: 
	 * Fix the program so that it terminates normally by changing exactly one 'jmp' (to 'nop') or 'nop' (to 'jmp'). 
	 * What is the value of the accumulator after the program terminates?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<Instruction> instructions = new ArrayList<>();
			for (String instructionLine : task.getPuzzleInput()) {
				instructions.add(new Instruction(instructionLine));
			}
			ProgramResult programResult;
			
			// fixing instructions one by one and checking if program goes to the end
			Integer nextInstructionToFix = Integer.valueOf(0);
			while (true) {
				// create a copy of the program (instructions set)
				List<Instruction> instructionsToRun = new ArrayList<>();
				for (Instruction instruction : instructions) instructionsToRun.add(new Instruction(instruction));
				// fixing the next 'jmp' or 'nop'
				for (int i=nextInstructionToFix; i<instructionsToRun.size(); i++) {
					Instruction instruction = instructionsToRun.get(i);
					switch (instruction.getOperation()) {
					case "nop":
						instruction.setOperation("jmp");
					case "jmp":
						instruction.setOperation("nop");
						nextInstructionToFix = i+1;
						i = instructionsToRun.size(); // to break the for loop
						break;
					}
				}
				
				programResult = runTheProgram(instructionsToRun);
				if (programResult.isSolutionFound()) break;
			}
			task.setAnswer((long)programResult.getAccumulator());
		} catch(Exception e) {}
		return task;
	}
	
	private ProgramResult runTheProgram(List<Instruction> instructionsToRun) {
		Integer accumulator = Integer.valueOf(0);
		Integer index = Integer.valueOf(0);
		while (true) {
			Instruction instruction = instructionsToRun.get(index);
			if(instruction.isUsed()) return new ProgramResult(accumulator, false);
			
			switch (instruction.getOperation()) {
			case "acc":
				accumulator += instruction.getArgument();
			case "nop":
				index++;
				break;
			case "jmp":
				index += instruction.getArgument();
				break;
			}
			instruction.setUsed(true);
			
			if (index == instructionsToRun.size()) return new ProgramResult(accumulator, true);
		}
	}
	
	private class ProgramResult {
		
		private final Integer accumulator;
		private final boolean solutionFound;
		
		public ProgramResult(Integer accumulator, boolean solutionFound) {
			this.accumulator = accumulator;
			this.solutionFound = solutionFound;
		}

		public Integer getAccumulator() {
			return accumulator;
		}

		public boolean isSolutionFound() {
			return solutionFound;
		}
		
	}
	
	private class Instruction {
		private String operation;
		private final Integer argument;
		private boolean used;
		
		public Instruction(String instructionLine) {
			String[] el = instructionLine.split(" ");
			this.operation = el[0];
			this.argument = Integer.valueOf(el[1]);
			this.used = false;
		}
		
		public Instruction(Instruction instruction) {
			this.operation = new String(instruction.getOperation());
			this.argument = instruction.getArgument();
			this.used = instruction.isUsed();
		}
		
		public boolean isUsed() {
			return used;
		}

		public void setUsed(boolean isUsed) {
			this.used = isUsed;
		}

		public String getOperation() {
			return operation;
		}

		public void setOperation(String operation) {
			this.operation = operation;
		}

		public Integer getArgument() {
			return argument;
		}

		@Override
		public String toString() {
			return "Instruction [operation=" + operation + ", argument=" + argument + ", used=" + used + "]";
		}
	}
}
