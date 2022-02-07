package bst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class BinarySearchTree<E extends Comparable> {
    BinaryNode<E> root;  // Används också i BSTVisaulizer
    int size;            // Används också i BSTVisaulizer
    private Comparator<E> ccomparator;
    
    public static void main(String[] args) {
    	BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
    	for (int i = 10; i < 20; i = i+2) {
    		bst.add(i);
    	}
    	bst.add(5);
    	bst.add(15);
    	bst.add(3);
    	bst.add(25);
    	bst.add(45);
    	bst.add(13);
    	bst.add(1);
    	bst.add(2);
    	
    	bst.add(3);
    	bst.add(2);
    	bst.add(1);
    	bst.add(4);
    	bst.add(5);
    	bst.add(0);
    	
    	BSTVisualizer bstv = new BSTVisualizer("Binary Search Tree Visualizer", 600, 600);
    	bstv.drawTree(bst);
    	bst.rebuild();
    	bstv.drawTree(bst);
    }
    
	/**
	 * Constructs an empty binary search tree.
	 */
	@SuppressWarnings("unchecked")
	public BinarySearchTree() {
		this.root = null;
		this.ccomparator = (e1, e2) -> e2.compareTo(e1);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.root = null;
		this.ccomparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		int sizeBefore = this.size;
		this.root = add(x, this.root);
		return sizeBefore != this.size;
	}
	
	/**
	 * Private recursive function for adding nodes to BST
	 * @param x, the element to be added.
	 * @param n, binary node to search
	 * @return boolean true if inserted, false if not.
	 */
	private BinaryNode<E> add(E x, BinaryNode<E> n) {
		if (n == null) {
			n = new BinaryNode<E>(x);
			this.size++;
			return n;
		}
		if (this.ccomparator.compare(x, n.element) > 0) {
			n.left = add(x, n.left);
		} else if (this.ccomparator.compare(x, n.element) < 0) {
			n.right = add(x, n.right);
		}
		return n;
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		if (this.root == null) return 0;
		return height(this.root);
	}
	
	/**
	 * Private recursive method to calc height of specific node
	 * @param n, the node from which to count the height
	 * @return int height
	 */
	private int height(BinaryNode<E> n) {
		if (n == null) return 0;
		return 1 + Math.max(height(n.left), height(n.right));
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		this.root = null;
		this.size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		printTree(this.root);
	}
	
	/**
	 * Helper private recursive function for printing in order
	 * @param n, the root of binary tree to be printed
	 */
	private void printTree(BinaryNode<E> n) {
		if (n == null) return;
		if (n.left == null && n.right == null) System.out.print(n.element + " ");
		printTree(n.left);
		System.out.print(n.element);
		printTree(n.right);
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {
		if (this.root == null) return;
		ArrayList<E> sorted = new ArrayList<E>();
		this.toArray(this.root, sorted);
		System.out.println(sorted);
		this.root = this.buildTree(sorted, 0, sorted.size()-1);
	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
		if (n == null) return;
		toArray(n.left, sorted);
		sorted.add(n.element);
		toArray(n.right, sorted);
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		if (first > last) return null;
		int mid = first + ((last - first)/2);
		BinaryNode<E> node = new BinaryNode<E>(sorted.get(mid));
		
		node.left = buildTree(sorted, first, mid-1);
		
		node.right = buildTree(sorted, mid+1, last);
		
		return node;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
