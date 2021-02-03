package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayTwoServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayTwoService service = new DayTwoService();
		assertEquals(Long.valueOf(2), service.solvePartOneTask(DayTwoService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayTwoService service = new DayTwoService();
		assertEquals(Long.valueOf(1), service.solvePartTwoTask(DayTwoService.EXAMPLE_INPUT).getAnswer());
	}

}
