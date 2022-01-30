package queue_singlelinkedlist;
import java.util.*;

public class FifoQueue<E> extends AbstractQueue<E> implements Queue<E> {
	private QueueNode<E> last;
	private int size;

	public FifoQueue() {
		super();
		last = null;
		size = 0;
	}

	/**	
	 * Inserts the specified element into this queue, if possible
	 * post:	The specified element is added to the rear of this queue
	 * @param	e the element to insert
	 * @return	true if it was possible to add the element 
	 * 			to this queue, else false
	 */
	public boolean offer(E e) {
		// empty
		if (this.last == null) {
			QueueNode<E> insert = new QueueNode<E>(e);
			this.last = insert;
			this.last.next = insert;
			this.size++;
			return true;
		}
		// one element
		if (this.last == this.last.next) {
			QueueNode<E> temp = this.last;
			QueueNode<E> insert = new QueueNode<E>(e);
			temp.next = insert;
			this.last = insert;
			insert.next = temp;
			this.size++;
			return true;
		}
		
		// multiple elements
		QueueNode<E> temp = this.last.next;
		while(temp != null) {
			if (temp == this.last) {
				QueueNode<E> insert = new QueueNode<E>(e);
				insert.next = this.last.next;
				temp.next = insert;
				this.last = insert;
				this.size++;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	/**	
	 * Returns the number of elements in this queue
	 * @return the number of elements in this queue
	 */
	public int size() {
		return this.size;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		if (this.last == null) return null;
		return this.last.next.element;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		if (this.last == null) return null;
		if (this.last == this.last.next) {
			this.size--;
			QueueNode<E> node = this.last;
			this.last = null;
			return node.element;
		}
		QueueNode<E> second = this.last.next.next;
		QueueNode<E> first = this.last.next;
		this.last.next = second;
		this.size--;
		return first.element;
	}
	
	/**
	* Appends the specified queue to this queue
	* post: all elements from the specified queue are appended
	* to this queue. The specified queue (q) is empty after the call.
	* @param q the queue to append
	* @throws IllegalArgumentException if this queue and q are identical
	*/
	public void append(FifoQueue<E> q) {
		if (q == this) throw new IllegalArgumentException();
		if (this.last == null) this.last = q.last;
		QueueNode<E> firstElement = this.last.next;
		QueueNode<E> lastElement = this.last;
		lastElement.next = q.last.next;
		q.last.next = firstElement;
		this.size += q.size();
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<E> {
		private QueueNode<E> pos;
		private int c;
		
		private QueueIterator () {
			pos = last;
			c = size;
		}
		
		public boolean hasNext() {
			return c > 0;
		}
		
		public E next() {
			if (hasNext()) {
				pos = pos.next;
				c--;
				return pos.element;
			} else {
				throw new NoSuchElementException();
			}
		}
		
		public void remove() {
			throw new UnsupportedOperationException();
		}
		
		
	}
	
	private static class QueueNode<E> {
		E element;
		QueueNode<E> next;

		private QueueNode(E x) {
			element = x;
			next = null;
		}
	}

}
