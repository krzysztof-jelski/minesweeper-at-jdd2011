package org.jdd;

public class Field {
	public String field;

	public Field(String field) {
		this.field = field;
	}

	boolean isPreviousSquareMine(int column) {
		return isSquareInBound(column - 1) && isMine(field.charAt(column - 1));
	}

	boolean isNextFieldMine(int column) {
		return isSquareInBound(column + 1) && isMine(field.charAt(column + 1));
	}

	private boolean isSquareInBound(int column) {
		return column < field.length() && column >= 0;
	}

	private static boolean isMine(char character) {
		return character == Minesweeper.MINE;
	}

	public boolean isMine(int column) {
		return isMine(field.charAt(column));
	}
}