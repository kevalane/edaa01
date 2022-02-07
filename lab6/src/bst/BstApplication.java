package bst;

public class BstApplication {

	public static void main(String[] args) {
		BinarySearchTree<String> bst = new BinarySearchTree<String>();
		bst.add("N");
		System.out.println(bst.height());
		bst.add("B");
		System.out.println(bst.height());
		bst.add("C");
		System.out.println(bst.height());
		bst.add("A");
		System.out.println(bst.height());
		bst.printTree();
	}

}
