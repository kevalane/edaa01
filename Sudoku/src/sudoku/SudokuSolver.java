package sudoku;

public interface SudokuSolver {
	/**
	 * To be done
	 */
//	boolean solve();

	/**
	 * Puts digit in the box row, col.
	 * 
	 * @param row   The row
	 * @param col   The column
	 * @param digit The digit to insert in box row, col
	 * @throws IllegalArgumentException if row, col or digit is outside the range
	 *                                  [0..9]
	 */
	void add(int row, int col, int digit);

	/**
	 * To be done
	 */
//	void remove(int row, int col);

	/**
	 * Returns the number at specified row and col
	 * @param row the row index (0-8) to be used
	 * @param col the column index (0-8) to be used
	 * @return the int at specified row and col
	 * @throws IllegalArgumentExpception if row and col are outside range [0-8]
	 * 									 or contain otherwise invalid data
	 */
	int get(int row, int col);

	/**
	 * Checks that all filled in digits follows the the sudoku rules.
	 */
//	boolean isValid();

	/**
	 * Clears the board by setting all numbers to 0
	 */
	void clear();

	/**
	 * Fills the grid with the digits in m. The digit 0 represents an empty box.
	 * 
	 * @param m the matrix with the digits to insert
	 * @throws IllegalArgumentException if m has the wrong dimension or contains
	 *                                  values outside the range [0..9]
	 */
	void setMatrix(int[][] m);

	/**
	 * Returns the board as a matrix filled with ints 0-9 where 0 indicates empty.
	 * @return an int[][] representation of the sudoku board.
	 */
	int[][] getMatrix();
}