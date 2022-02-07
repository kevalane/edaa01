package bst;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {
	
	private BinarySearchTree<Integer> intBst;
	private BinarySearchTree<String> stringBst;

	@BeforeEach
	void setUp() throws Exception {
		this.intBst = new BinarySearchTree<Integer>();
		this.stringBst = new BinarySearchTree<String>();
	}

	@AfterEach
	void tearDown() throws Exception {
		this.intBst = null;
		this.stringBst = null;
	}

	@Test
	void testEmptyConstructor() {
		assertNull(this.intBst.root);
		assertNull(this.stringBst.root);
		assertEquals(0, this.intBst.size());
		assertEquals(0, this.stringBst.size());
		assertEquals(0, this.intBst.height());
		assertEquals(0, this.stringBst.height());
	}
	
	@Test
	void testCompConstructor() {
		this.stringBst = new BinarySearchTree<String>((e1, e2) -> e2.length() - e1.length());
		assertNull(this.stringBst.root);
		assertEquals(0, this.stringBst.size());
		assertEquals(0, this.stringBst.height());
	}
	
	@Test // check sizes
	void testIntAddElement() {
		assertTrue(this.intBst.add(6));
		assertEquals(6, this.intBst.root.element);
		
		assertTrue(this.intBst.add(3));
		assertEquals(3, this.intBst.root.left.element);
		
		assertFalse(this.intBst.add(6));
		
		assertTrue(this.intBst.add(2));
		assertEquals(2, this.intBst.root.left.left.element);
		
		assertTrue(this.intBst.add(5));
		assertEquals(5, this.intBst.root.left.right.element);
		
		assertFalse(this.intBst.add(2));
		
		assertTrue(this.intBst.add(10));
		assertEquals(10, this.intBst.root.right.element);
		
		assertTrue(this.intBst.add(8));
		assertEquals(8, this.intBst.root.right.left.element);
		
		assertFalse(this.intBst.add(8));
	}
	
	@Test
	void testHeight() {
		assertEquals(0, this.stringBst.height());
		assertTrue(this.stringBst.add("hello"));
		assertEquals(1, this.stringBst.height());
		assertTrue(this.stringBst.add("abc"));
		assertEquals(2, this.stringBst.height());
		assertTrue(this.stringBst.add("mn"));
		assertEquals(2, this.stringBst.height());
		assertTrue(this.stringBst.add("adc"));
		assertEquals(3, this.stringBst.height());
	}
	
	@Test
	void testSize() {
		assertEquals(0, this.stringBst.size());
		assertTrue(this.stringBst.add("hello"));
		assertEquals(1, this.stringBst.size());
		assertTrue(this.stringBst.add("abc"));
		assertEquals(2, this.stringBst.size());
		assertTrue(this.stringBst.add("mn"));
		assertEquals(3, this.stringBst.size());
		assertTrue(this.stringBst.add("adc"));
		assertEquals(4, this.stringBst.size());
	}
	
}
