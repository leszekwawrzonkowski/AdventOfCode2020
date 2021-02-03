package pl.lw.adventofcode.twentytwenty.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DayOneServiceTest {

	@Test
	void testSolvePartOneTask() {
		DayOneService service = new DayOneService();
		assertEquals(Long.valueOf(514579), service.solvePartOneTask(DayOneService.EXAMPLE_INPUT).getAnswer());
	}

	@Test
	void testSolvePartTwoTask() {
		DayOneService service = new DayOneService();
		assertEquals(Long.valueOf(241861950), service.solvePartTwoTask(DayOneService.EXAMPLE_INPUT).getAnswer());
	}

}
