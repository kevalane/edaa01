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
			this.last = new QueueNode<E>(e);
			return true;
		}
		// one element
		if (this.last == this.last.next) {
			QueueNode<E> temp = this.last;
			QueueNode<E> insert = new QueueNode<E>(e);
			temp.next = insert;
			this.last = insert;
			insert.next = temp;
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
		if (this.last == null) return 0;
		if (this.last == this.last.next) return 1;
		QueueNode<E> temp = this.last.next;
		int i = 0;
		do {
			i++;
			temp = temp.next;
		} while(temp != this.last);
		return i;
	}
	
	/**	
	 * Retrieves, but does not remove, the head of this queue, 
	 * returning null if this queue is empty
	 * @return 	the head element of this queue, or null 
	 * 			if this queue is empty
	 */
	public E peek() {
		return null;
	}

	/**	
	 * Retrieves and removes the head of this queue, 
	 * or null if this queue is empty.
	 * post:	the head of the queue is removed if it was not empty
	 * @return 	the head of this queue, or null if the queue is empty 
	 */
	public E poll() {
		return null;
	}
	
	/**	
	 * Returns an iterator over the elements in this queue
	 * @return an iterator over the elements in this queue
	 */	
	public Iterator<E> iterator() {
		return null;
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
