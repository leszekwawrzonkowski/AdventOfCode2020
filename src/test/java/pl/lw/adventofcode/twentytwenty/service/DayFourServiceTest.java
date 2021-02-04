package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayFourServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayFourService service = new DayFourService();
		assertEquals(Long.valueOf(2), service.solvePartOneTask(DayFourService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayFourService service = new DayFourService();
		assertEquals(Long.valueOf(2), service.solvePartTwoTask(DayFourService.EXAMPLE_INPUT).getAnswer());
	}

}
