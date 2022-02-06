package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> ccomparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this.root = null;
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
		BinaryNode<E> returnNode = add(x, this.root);
		if (returnNode == null) return false;
		this.size++;
		return true;
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
			return n;
		}
		if (n.element.equals(x)) return null;
		if (this.ccomparator.compare(x, n.element) < 0) {
			BinaryNode<E> returnNode = add(x, n.left);
			this.root.left = returnNode;
			return returnNode;
		} else {
			BinaryNode<E> returnNode = add(x, n.right);
			this.root.right = returnNode;
			return returnNode;
		}
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		if (this.root == null) return 0;
		return 1 + height(this.root);
	}
	
	/**
	 * Private recursive method to calc height of specific node
	 * @param n, the node from which to count the height
	 * @return int height
	 */
	private int height(BinaryNode<E> n) {
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
		if (n.left == null && n.right == null) System.out.print(n.element);
		printTree(n.left);
		System.out.print(n.element);
		printTree(n.right);
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
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
