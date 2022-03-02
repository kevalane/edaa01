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
	
	public void add(int row, int col, int digit) throws IllegalArgumentException {
		if ((row < 0 || row > 8) || (col < 0 || col > 8)) throw new IllegalArgumentException("Row and col must be int 0-8.");
		if (digit < 0 || digit > 9) throw new IllegalArgumentException("Digit must be between 0-9");
		this.board[row][col] = digit;
	}
	
	public void remove(int row, int col) {
		
	}
	
	public void setMatrix(int[][] m) throws IllegalArgumentException {
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
	
	public void clear() {
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++) {
				this.board[i][k] = 0;
			}
		}
	}
	
	public int get(int row, int col) throws IllegalArgumentException {
		if ((row < 0 || row > 8) || (col < 0 || col > 8)) throw new IllegalArgumentException("Parameters must be int 0-8.");
		return this.board[row][col];
	}
}
