package sudoku;

import java.util.ArrayList;

import javax.swing.JTextField;

public class Sudoku implements SudokuSolver {
	
	public static final int SIZE = 9;
	public static final int BOX_SIZE = SIZE/3;
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
	
	public void addUserInput(JTextField[][] tf) throws IllegalArgumentException {
		if (tf.length != SIZE || tf[0].length != SIZE) throw new IllegalArgumentException("Wrong dimensions on input textfield!");
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (tf[i][j].getText().equals("")) {
					this.add(i,j,0);
				} else {
					int z;
					try {
						z = Integer.parseInt(tf[i][j].getText());
					} catch (Exception e) {
						throw new IllegalArgumentException("Textfield contains a non-integer!");
					}
					if (z < 0 || z > SIZE) throw new IllegalArgumentException("Only numbers between 0-9 are allowed.");
					this.add(i,j,z);
				}				
			}
		}
	}
	
	public boolean solve() { 
		return solve(0,0);
	}
	
	/**
	 * Recursive helper algorithm for checking if sudoku is solvable.
	 * @param r, the row index to be tested
	 * @param c, the col index to be tested
	 * @return true if solvable, false if not
	 */
	private boolean solve(int r, int c) {
		if (r == 9) return true;
		
		if (this.get(r,c) == 0) {
			for (int i = 1; i <= SIZE; i++) {
				this.add(r,c,i);
				
				if (isValid()) {
					if (c != SIZE - 1) {
						if (solve(r, c+1)) return true;
					} else {
						if (solve(r+1, 0)) return true;
					}
				}
			}
			this.remove(r,c);
			return false;
		} else {
			if (this.isValid()) {
				if (c != SIZE - 1) {
					if (solve(r, c+1)) return true;
				} else {
					if (solve(r+1, 0)) return true;
				}
			}
		}
		return false;
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
