package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DaySixServiceTest {

	@Test
	void testSolvePartOneTask() {
		DaySixService service = new DaySixService();
		assertEquals(Long.valueOf(11), service.solvePartOneTask(DaySixService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DaySixService service = new DaySixService();
		assertEquals(Long.valueOf(6), service.solvePartTwoTask(DaySixService.EXAMPLE_INPUT).getAnswer());
	}

}
