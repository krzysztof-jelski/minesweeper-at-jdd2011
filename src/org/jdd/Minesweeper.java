package org.jdd;

public class Minesweeper {

	public Minesweeper(int rows, int columns) {
		validate(rows, columns);
	}

	static final char MINE = '*';

	public String solve(String... fieldAsString) {
		String output = "";

		for (String string : fieldAsString) {
			Field field = new Field(string);
			for (int column = 0; column < string.length(); column++) {
				if (field.isMine(column)) {
					output += MINE;
				} else {
					output += countMines(field, column);
				}
			}
			output += '\n';
		}
		return output.substring(0, output.length() - 1);
	}

	private int countMines(Field field, int index) {
		int count = 0;
		if (field.isPreviousSquareMine(index)) {
			count++;
		}
		if (field.isNextFieldMine(index))
			count++;
		return count;
	}

	private void validate(int rows, int columns) {
		if (rows <= 0 || columns <= 0) {
			throw new InvalidInputParameters();
		}
	}

}
