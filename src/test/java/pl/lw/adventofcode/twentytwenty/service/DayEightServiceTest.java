package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayEightServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayEightService service = new DayEightService();
		assertEquals(Long.valueOf(5), service.solvePartOneTask(DayEightService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayEightService service = new DayEightService();
		assertEquals(Long.valueOf(8), service.solvePartTwoTask(DayEightService.EXAMPLE_INPUT).getAnswer());
	}

}
