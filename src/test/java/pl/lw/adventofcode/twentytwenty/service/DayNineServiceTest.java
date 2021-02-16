package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayNineServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayNineService service = new DayNineService();
		assertEquals(Long.valueOf(127), service.solvePartOneTask(DayNineService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayNineService service = new DayNineService();
		assertEquals(Long.valueOf(62), service.solvePartTwoTask(DayNineService.EXAMPLE_INPUT).getAnswer());
	}

}
