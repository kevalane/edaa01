package sudoku;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuSpec {
	
	private Sudoku s;

	@BeforeEach
	void setUp() throws Exception {
		this.s = new Sudoku();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.s = null;
	}

	@Test
	void testSetMatrix() {
		// a valid case
		int[][] m = {{0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,6,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,1,0,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,2,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,9,0,0}};
		this.s.setMatrix(m);
		
		assertArrayEquals(m, this.s.getMatrix());
		
		// test wrong dimension
		int[][] m = {{0,0,1}, {1,1,1}, {5,1,0}};
		assertThrows(new IllegalArgumentException(), this.s.setMatrix(m));
	}

}
