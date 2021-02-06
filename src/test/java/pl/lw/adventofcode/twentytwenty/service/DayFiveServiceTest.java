package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayFiveServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayFiveService service = new DayFiveService();
		assertEquals(Long.valueOf(820), service.solvePartOneTask(DayFiveService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayFiveService service = new DayFiveService();
		assertEquals(Long.valueOf(120), service.solvePartTwoTask(DayFiveService.EXAMPLE_INPUT).getAnswer());
	}

}
