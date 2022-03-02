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
		int[][] m1 = {{0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,6,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,1,0,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,2,0,0,0,0},
					 {0,0,0,0,0,0,0,0,0},
					 {0,0,0,0,0,0,9,0,0}};
		this.s.setMatrix(m1);
		
		assertArrayEquals(m1, this.s.getMatrix());
		
		// test wrong dimension
		int[][] m2 = {{0,0,1}, {1,1,1}, {5,1,0}};
		assertThrows(IllegalArgumentException.class, () -> this.s.setMatrix(m2));
		
		// test using number larger than 9
		int[][] m3 = {{0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,6,0,0,0,0},
				 {0,0,0,14,0,0,0,0,0},
				 {0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,2,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,9,0,0}};
		assertThrows(IllegalArgumentException.class, () -> this.s.setMatrix(m3));
		
		// test number less than 0
				int[][] m4 = {{0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,6,0,0,0,0},
						 {0,0,0,14,0,0,0,0,0},
						 {0,0,0,1,0,0,0,0,0},
						 {0,0,-10,0,0,0,0,0,0},
						 {0,0,0,0,2,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,9,0,0}};
				assertThrows(IllegalArgumentException.class, () -> this.s.setMatrix(m4));
	}

}
