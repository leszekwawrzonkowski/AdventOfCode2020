package pl.lw.adventofcode.twentytwenty.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pl.lw.adventofcode.twentytwenty.domain.DayInfo;
import pl.lw.adventofcode.twentytwenty.domain.DayTaskWithStrings;

@Service
public class DayFiveService {
	
	public static final String ID = "D5";
	public static final String EXAMPLE_INPUT = ""
			+ "FBFBBFFRLR\n"
			+ "BFFFBBFRRR\n"
			+ "FFFBBBFRRR\n"
			+ "BBFFBBFRLL";
	
	public static DayInfo getDayInfo() {
		return new DayInfo(ID, EXAMPLE_INPUT);
	}

	/** AoC2020 D5T1 task description: 
	 * As a sanity check, look through your list of boarding passes. 
	 * What is the highest seat ID on a boarding pass?
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartOneTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<Seat> seats = new ArrayList<>();
			for (String boardingPass : task.getPuzzleInput()) {
				seats.add(new Seat(boardingPass));
			}
			task.setAnswer((long)seats.stream().max(Comparator.comparing(s -> s.getId())).get().getId());
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D5T2 task description: 
	 * It's a completely full flight, so your seat should be the only missing boarding pass in your list. 
	 * However, there's a catch: some of the seats at the very front and back of the plane don't exist on this aircraft, 
	 * so they'll be missing from your list as well. 
	 * Your seat wasn't at the very front or back, though; the seats with IDs +1 and -1 from yours will be in your list.
	 * 
	 * @param input puzzle input
	 * @return day task solved
	 */
	public DayTaskWithStrings solvePartTwoTask(String input) {
		DayTaskWithStrings task = new DayTaskWithStrings();
		try {
			task.setPuzzleInput(input);
			List<Seat> seats = new ArrayList<>();
			for (String boardingPass : task.getPuzzleInput()) {
				seats.add(new Seat(boardingPass));
			}
			List<Seat> sortedSeats = seats.stream().sorted(Comparator.comparing(s -> s.getId())).collect(Collectors.toList());
			Integer missingSeatId = null;
			for (Seat seat : sortedSeats) {
				if (missingSeatId != null && missingSeatId + 1 != seat.getId()) {
					//the next seat is "the only missing boarding pass in your list"
					task.setAnswer((long)(missingSeatId + 1));
					break;
				}
				missingSeatId = seat.getId();
			}
			
		} catch(Exception e) {}
		return task;
	}
	
	/** AoC2020 D5 seat info: 
	 * The first 7 characters will either be 'F' or 'B'; 
	 * these specify exactly one of the 128 rows on the plane (numbered 0 through 127). 
	 * Each letter tells you which half of a region the given seat is in. 
	 * Start with the whole list of rows; 
	 * the first letter indicates whether the seat is in the front (0 through 63) or the back (64 through 127). 
	 * The next letter indicates which half of that region the seat is in, and so on until you're left with exactly one row. 
	 * The last three characters will be either 'L' or 'R'; 
	 * these specify exactly one of the 8 columns of seats on the plane (numbered 0 through 7). 
	 * The same process as above proceeds again, this time with only three steps. 
	 * 'L' means to keep the lower half, while 'R' means to keep the upper half.
	 * Every seat also has a unique seat ID: multiply the row by 8, then add the column.
	 */
	private class Seat {
		private Integer row;
		private Integer column;
		private Integer id;
		
		private char rowDirectionLowerHalf = 'F';
		private char rowDirectionUpperHalf = 'B';
		private char colDirectionLowerHalf = 'L';
		private char colDirectionUpperHalf = 'R';
		
		
		/** Creates the seat from the boarding pass.
		 */
		public Seat(String boardingPass) throws Exception {
			// System.out.println("Building seat for boarding pass '"+boardingPass+"'");
			Range rowCandidate = new Range(0, 127);
			char[] rowDirections = boardingPass.substring(0, 7).toCharArray();
			for (char rowDir : rowDirections) {
				// System.out.println("row dir="+rowDir+" range before="+rowCandidate);
				rowCandidate = rowCandidate.getSubRange(rowDir, this.rowDirectionLowerHalf, this.rowDirectionUpperHalf);
				// System.out.println("row dir="+rowDir+" range after="+rowCandidate);
			}
			if(rowCandidate.start != rowCandidate.end) throw new Exception("Row candidate not found for boarding pass '"+boardingPass+"'. "
					+ "Found S="+rowCandidate.start+" E="+rowCandidate.end);
			this.row = rowCandidate.start;
			
			Range colCandidate = new Range(0, 7);
			char[] colDirections = boardingPass.substring(7, 10).toCharArray();
			for (char colDir : colDirections) {
				// System.out.println("col dir="+colDir+" range before="+colCandidate);
				colCandidate = colCandidate.getSubRange(colDir, this.colDirectionLowerHalf, this.colDirectionUpperHalf);
				// System.out.println("col dir="+colDir+" range after="+colCandidate);
			}
			if(colCandidate.start != colCandidate.end) throw new Exception("Column candidate not found for boarding pass '"+boardingPass+"'. "
					+ "Found S="+colCandidate.start+" E="+colCandidate.end);
			this.column = colCandidate.start;
			
			this.id = this.row * 8 + this.column;
		}


		public Integer getId() {
			return id;
		}
	}
	
	/** Useful during seat creation.
	 */
	private class Range {
		private Integer start;
		private Integer end;
		
		public Range(Integer start, Integer end) {
			this.start = start;
			this.end = end;
		}
		
		/** Return lower or upper half of that range.
		 */
		public Range getSubRange(char direction, char lowerHalf, char upperHalf) {
			if(direction == lowerHalf) return new Range(this.start, this.start + (this.end-this.start)/2);
			if(direction == upperHalf) return new Range(this.start + (this.end-this.start)/2 + 1, this.end);
			return null;
		}

		@Override
		public String toString() {
			return "Range [start=" + start + ", end=" + end + "]";
		}
	}
}
