package sudoku;

public class Sudoku implements SudokuSolver {
	
	private static final int SIZE = 9;
	private int[][] board;
	
	public Sudoku() {
		this.board = new int[SIZE][SIZE];
	}
	
	public int[][] getMatrix() {
		return this.board;
	}
	
	public void setMatrix(int[][] m) {
		// check dimension
		if (m[0].length != 9 || m.length != 9) throw new IllegalArgumentException("Input matrix has wrong dimensions.");
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++) {
				try {
					if (m[i][k] < 0 || m[i][k] > 9) throw new IllegalArgumentException("Invalid value inside input matrix");
					this.board[i][k] = m[i][k];
				} catch (Exception e) {
					throw new IllegalArgumentException("Invalid value inside input matrix.");
				}
			}
		}
	}
}
