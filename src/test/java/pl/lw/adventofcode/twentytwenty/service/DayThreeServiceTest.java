package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayThreeServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayThreeService service = new DayThreeService();
		assertEquals(Long.valueOf(7), service.solvePartOneTask(DayThreeService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayThreeService service = new DayThreeService();
		assertEquals(Long.valueOf(336), service.solvePartTwoTask(DayThreeService.EXAMPLE_INPUT).getAnswer());
	}

}
