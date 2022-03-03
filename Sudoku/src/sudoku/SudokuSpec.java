package sudoku;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JTextField;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuSpec {
	
	private SudokuSolver s;

	@BeforeEach
	void setUp() throws Exception {
		this.s = new Sudoku();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		this.s = null;
	}
	
	@Test
	void testConstructor() {
		int[][] empty = {{0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0},
						 {0,0,0,0,0,0,0,0,0}};
		assertArrayEquals(this.s.getMatrix(), empty);
	}
	
	@Test
	void testSolve() {
		// test empty
		assertTrue(this.s.solve());
		this.s.clear();
		
		// test one with illegal start
		this.s.add(0,0,1);
		this.s.add(1,0,1);
		assertFalse(this.s.solve());
		this.s.clear();
		
		// test one with illegal start in end
		this.s.add(8,8,1);
		this.s.add(8,7,1);
		assertFalse(this.s.solve());
		this.s.clear();
		
		// test one solveable, numbers set in end
		this.s.add(8,8,1);
		assertTrue(this.s.solve());
		
		// test one with many numbers, not solveable
		this.s.add(0,0,1);
		this.s.add(0,1,2);
		this.s.add(0,2,3);
		this.s.add(1,0,4);
		this.s.add(1,1,5);
		this.s.add(1,2,6);
		this.s.add(2,3,7);
		assertFalse(this.s.solve());
		this.s.clear();
		
		// test one with many numbers, solveable
		this.s.add(0,0,1);
		this.s.add(0,1,2);
		this.s.add(0,2,3);
		this.s.add(1,0,4);
		this.s.add(1,1,5);
		this.s.add(1,2,6);
		assertTrue(this.s.solve());
		this.s.clear();
		
	}
	
	@Test 
	void testAddUserInput() {
		// test input string
		JTextField[][] tf = new JTextField[Sudoku.SIZE][Sudoku.SIZE];
		for (int i = 0; i < 9; i++){
			for (int k = 0; k < 9; k++){
				tf[i][k] = new JTextField();
			}
		}
		tf[4][4].setText("a");
		assertThrows(IllegalArgumentException.class, () -> this.s.addUserInput(tf));
		this.s.clear();
		
		// test input of too large number
		tf[4][4].setText("");
		tf[2][5].setText("10");
		assertThrows(IllegalArgumentException.class, () -> this.s.addUserInput(tf));
		this.s.clear();
		
		// test wrong dimensions
		JTextField[][] tf2 = new JTextField[1][1];
		tf2[0][0] = new JTextField();
		assertThrows(IllegalArgumentException.class, () -> this.s.addUserInput(tf2));
		this.s.clear();
		
		// test valid input
		tf[2][5].setText("");
		tf[1][1].setText("1");
		tf[1][5].setText("2");
		this.s.addUserInput(tf);
		assertEquals(this.s.get(2,5), 0);
		assertEquals(this.s.get(1,1), 1);
		assertEquals(this.s.get(1,5), 2);
	}
	
	@Test
	void testIsValid() {
		// test empty board
		int[][] empty = {{0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0}};
		this.s.setMatrix(empty);
		assertTrue(this.s.isValid());
		
		// test valid board 
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
		assertTrue(this.s.isValid());
		
		// test duplicate in row
		int[][] m2 = {{1,1,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,6,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,2,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,9,0,0}};
		this.s.setMatrix(m2);
		assertFalse(this.s.isValid());
		
		// test invalid box
		int[][] m3 = {{1,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,6,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,1,0,0,0,0},
				 {0,0,0,0,2,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,9,0,0}};
		this.s.setMatrix(m3);
		assertFalse(this.s.isValid());
		
		// test invalid col
		int[][] m4 = {{1,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,6,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,1,0,0,0,0,0},
				 {0,0,0,0,1,0,0,0,0},
				 {0,0,0,0,2,0,0,0,0},
				 {1,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,9,0,0}};
		this.s.setMatrix(m4);
		assertFalse(this.s.isValid());
	}
	
	@Test
	void testRemove() {
		// test invalid rows and cols
		assertThrows(IllegalArgumentException.class, () -> this.s.get(-1,5));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(20,5));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(4,-100));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(5,40));
		
		this.s.add(4,6,7);
		assertEquals(this.s.get(4,6), 7);
		this.s.remove(4,6);
		assertEquals(this.s.get(4,6), 0);
	}
	
	@Test
	void testAdd() {
		// test invalid rows and cols
		assertThrows(IllegalArgumentException.class, () -> this.s.add(-1,5,1));
		assertThrows(IllegalArgumentException.class, () -> this.s.add(20,5,1));
		assertThrows(IllegalArgumentException.class, () -> this.s.add(4,-100,1));
		assertThrows(IllegalArgumentException.class, () -> this.s.add(5,40,1));
		// test invalid digit
		assertThrows(IllegalArgumentException.class, () -> this.s.add(5,5,-1));
		assertThrows(IllegalArgumentException.class, () -> this.s.add(5,5,10));
		
		// check added
		this.s.add(1,2,4);
		assertEquals(this.s.get(1,2), 4);
	}
	
	@Test
	void testGet() {
		// test invalid rows and cols
		assertThrows(IllegalArgumentException.class, () -> this.s.get(-1,5));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(20,5));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(4,-100));
		assertThrows(IllegalArgumentException.class, () -> this.s.get(5,40));
		
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
		assertEquals(this.s.get(0,5), 0);
		assertEquals(this.s.get(2,4), 6);
		assertEquals(this.s.get(4,3), 1);
		assertEquals(this.s.get(6,4), 2);
		assertEquals(this.s.get(8,6), 9);
		
	}
	
	@Test
	void testClear() {
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
		assertArrayEquals(this.s.getMatrix(), m1);
		this.s.clear();
		int[][] empty = {{0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0},
				 {0,0,0,0,0,0,0,0,0}};
		assertArrayEquals(this.s.getMatrix(), empty);
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
