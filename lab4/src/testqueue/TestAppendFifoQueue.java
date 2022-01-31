package testqueue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import queue_singlelinkedlist.FifoQueue;

public class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue;
	private FifoQueue<Integer> myIntQueue2;
	private FifoQueue<String> myStringQueue;
	private FifoQueue<String> myStringQueue2;
	
	@BeforeEach
	void setUp() {
		myIntQueue = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
		myStringQueue = new FifoQueue<String>();
		myStringQueue2 = new FifoQueue<String>();
	}

	@AfterEach
	void tearDown(){
		myIntQueue = null;
		myStringQueue = null;
	}
	
	/**
	 * Test concatenate two empty lists
	 */
	@Test
	void testConcatTwoEmpty() {
		myIntQueue.append(myIntQueue2);
		myStringQueue.append(myStringQueue2);
		assertTrue(myIntQueue.isEmpty(), "Wrong result from empty of queue");
		assertEquals(0, myIntQueue.size(), "Wrong size of empty queue");
		assertTrue(myStringQueue.isEmpty(), "Wrong result from empty of queue");
		assertEquals(0, myStringQueue.size(), "Wrong size of empty queue");
		assertTrue(myStringQueue2.isEmpty(), "Queue of strings 2 should be empty");
	}
	
	/**
	 * Empty queue concat to non-empty queue
	 */
	@Test
	void testConcatEmptyWithQueue() {
		myStringQueue2.offer("First");
		myStringQueue2.offer("Second");
		myStringQueue2.offer("Third");
		myStringQueue.append(myStringQueue2);
		assertEquals(3, myStringQueue.size(), "Wrong size of queue");
		assertEquals("First", myStringQueue.peek(), "peek on queue of strings");
		assertEquals("First", myStringQueue.poll(), "String First expected");
		assertEquals("Second", myStringQueue.poll(), "String Second expected");
		assertEquals("Third", myStringQueue.poll(), "String Third expected");
		assertTrue(myStringQueue.isEmpty(), "Queue of strings should be empty");
		assertTrue(myStringQueue2.isEmpty(), "Queue of strings 2 should be empty");
	}
	
	/**
	 * Non-empty queue contcat to empty queue
	 */
	@Test
	void testConcatQueueWithEmpty() {
		myStringQueue.offer("First");
		myStringQueue.offer("Second");
		myStringQueue.offer("Third");
		myStringQueue.append(myStringQueue2);
		assertEquals(3, myStringQueue.size(), "Wrong size of queue");
		assertEquals("First", myStringQueue.peek(), "peek on queue of strings");
		assertEquals("First", myStringQueue.poll(), "String First expected");
		assertEquals("Second", myStringQueue.poll(), "String Second expected");
		assertEquals("Third", myStringQueue.poll(), "String Third expected");
		assertTrue(myStringQueue.isEmpty(), "Queue of strings should be empty");
		assertTrue(myStringQueue2.isEmpty(), "Queue of strings 2 should be empty");
	}
	
	/**
	 * Non-empty queue concat with non-empty queue
	 */
	@Test
	void concatTwoQueues() {
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		myIntQueue.offer(4);
		myIntQueue2.offer(11);
		myIntQueue2.offer(12);
		myIntQueue2.offer(13);
		myIntQueue2.offer(14);
		myIntQueue.append(myIntQueue2);
		assertEquals(8, myIntQueue.size(), "Wrong size of empty queue");
		assertEquals(1, myIntQueue.peek(), "peek on queue of ints");
		assertEquals(1, myIntQueue.poll(), "int 1 expected");
		assertEquals(2, myIntQueue.poll(), "int 2 expected");
		assertEquals(3, myIntQueue.poll(), "int 3 expected");
		assertEquals(4, myIntQueue.poll(), "int 4 expected");
		assertEquals(11, myIntQueue.poll(), "int 11 expected");
		assertEquals(12, myIntQueue.poll(), "int 12 expected");
		assertEquals(13, myIntQueue.poll(), "int 13 expected");
		assertEquals(14, myIntQueue.poll(), "int 14 expected");
		assertTrue(myIntQueue.isEmpty(), "Queue of ints should be empty");
		assertTrue(myIntQueue2.isEmpty(), "Queue of ints 2 should be empty");
	}
	
	/**
	 * Concat same queue with itself
	 */
	@Test
	void concatSameQueue() {
		myIntQueue.offer(1);
		myIntQueue.offer(2);
		myIntQueue.offer(3);
		assertThrows(IllegalArgumentException.class, () -> myIntQueue.append(myIntQueue));
		assertEquals(3, myIntQueue.size(), "Wrong size of queue");
	}
}
