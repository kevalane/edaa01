package sudoku;

import java.util.ArrayList;

public class Sudoku implements SudokuSolver {
	
	private static final int SIZE = 9;
	private static final int BOX_SIZE = 3;
	private int[][] board;
	
	public Sudoku() {
		this.board = new int[SIZE][SIZE];
	}
	
	public int[][] getMatrix() {
		return this.board;
	}
	
	public void add(int row, int col, int digit) throws IllegalArgumentException {
		if ((row < 0 || row > SIZE - 1) || (col < 0 || col > SIZE - 1)) throw new IllegalArgumentException("Row and col must be int 0-8.");
		if (digit < 0 || digit > SIZE) throw new IllegalArgumentException("Digit must be between 0-9");
		this.board[row][col] = digit;
	}
	
	public void remove(int row, int col) throws IllegalArgumentException {
		if ((row < 0 || row > SIZE - 1) || (col < 0 || col > SIZE - 1)) throw new IllegalArgumentException("Row and col must be int 0-8.");
		this.board[row][col] = 0;
	}
	
	public void setMatrix(int[][] m) throws IllegalArgumentException {
		// check dimension
		if (m[0].length != SIZE || m.length != SIZE) throw new IllegalArgumentException("Input matrix has wrong dimensions.");
		for (int i = 0; i < SIZE; i++) {
			for (int k = 0; k < SIZE; k++) {
				try {
					if (m[i][k] < 0 || m[i][k] > SIZE) throw new IllegalArgumentException("Invalid value inside input matrix");
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
		if ((row < 0 || row > SIZE - 1) || (col < 0 || col > SIZE - 1)) throw new IllegalArgumentException("Parameters must be int 0-8.");
		return this.board[row][col];
	}
	
	public boolean solve() { 
		
	}
	
	public boolean isValid() {
		// check rows
		for (int i = 0; i < SIZE; i++) {
			if (!this.checkArray(this.board[i])) return false;
		}
		// check cols
		for (int i = 0; i < SIZE; i++) {
			int[] col = new int[SIZE];
			for (int k = 0; k < SIZE; k++) {
				col[k] = this.board[k][i];
			}
			if (!this.checkArray(col)) return false;
		}
		// check 3x3s
		for (int i = 0; i < SIZE; i = i+BOX_SIZE) {
			for (int k = 0; k < SIZE; k = k+BOX_SIZE) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for (int a = i; a < i+3; a++) {
					for (int b = k; b < k+3; b++) {
						list.add(this.board[a][b]);
					}
				}
				int[] arr = list.stream().mapToInt(val -> val).toArray();
				if (!checkArray(arr)) return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if an array of 9 numbers contain dublicates of numbers 1-9
	 * @param arr, ant array of int[] of size 9 to be checked for duplicates
	 * @return true if no duplicates, false if dublicates
	 */
	private boolean checkArray(int[] arr) {
		int[] freq = new int[SIZE+1];
		for (int i = 0; i < SIZE; i++) {
			freq[arr[i]]++;
		}
		// check if any double
		for (int i = 1; i <= SIZE; i++) {
			if (freq[i] > 1) return false;
		}
		return true;
	}
}
