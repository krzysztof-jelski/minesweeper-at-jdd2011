package org.jdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinesweeperTest {

	private Minesweeper minesweeper;

	@Test
	public void shouldLeaveMineOnField() {
		String hints = solve(1, 1, "*");

		assertEquals("*", hints);
	}

	private String solve(int rows, int columns, String... field) {
		minesweeper = new Minesweeper(rows, columns);
		return minesweeper.solve(field);
	}

	@Test(expected = InvalidInputParameters.class)
	public void shouldNotAcceptFieldWithNoColumn() {
		solve(1, 0, "");
	}

	@Test(expected = InvalidInputParameters.class)
	public void shouldNotAcceptFieldWithNoRows() {
		solve(0, 1, "");
	}

	@Test
	public void shouldProcessEmptyField() {
		String hints = solve(1, 1, ".");

		assertEquals("0", hints);
	}

	@Test
	public void shouldProcessOneRowWithMineOnTheFirstSquare() {
		String hints = solve(1, 2, "*.");

		assertEquals("*1", hints);
	}

	@Test
	public void shouldProcessTwoEmptySquares() {
		String hints = solve(1, 2, "..");

		assertEquals("00", hints);
	}

	@Test
	public void shouldProcessTwoMines() {
		String hints = solve(1, 2, "**");

		assertEquals("**", hints);
	}

	@Test
	public void shouldCountOnlyNeighbour() {
		String hints = solve(1, 3, "*..");

		assertEquals("*10", hints);
	}

	@Test
	public void shouldProcessTwoRows() {
		String hints = solve(2, 1, ".", ".");

		assertEquals("0\n0", hints);
	}
}
