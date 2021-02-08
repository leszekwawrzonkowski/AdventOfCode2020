package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DaySevenServiceTest {

	@Test
	void testSolvePartOneTask() {
		DaySevenService service = new DaySevenService();
		assertEquals(Long.valueOf(4), service.solvePartOneTask(DaySevenService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DaySevenService service = new DaySevenService();
		assertEquals(Long.valueOf(32), service.solvePartTwoTask(DaySevenService.EXAMPLE_INPUT).getAnswer());
	}

}
