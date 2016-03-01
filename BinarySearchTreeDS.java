public class BinarySearchTreeDS<Key extends Comparable<Key>, Value> {
  //My node of a BST
	private class Node
	{
		Key key;
		Value value;
		Node left, right;
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	//My root
	private Node root;
	//My APIs	
	public void put(Key key, Value value)
	{
		this.root = put(root, key, value);
	}
	
	public Value get(Key key)
	{
		Node root = this.root;
		Node valueNode = get(root, key);
		return valueNode.value;
	}
	
	public void delete(Key key)
	{
		Node root = this.root;
		delete(root, key, root);
	}
	
	public boolean contains(Key key)
	{
		return contains(this.root, key);
	}
	
	//Helping methods
	public Node put(Node root, Key key, Value value)
	{
		if(root == null)
		{
			System.out.println("Inserting " + key + " with Value " + value);
			return new Node(key, value);
		}
		if(root.key.compareTo(key) < 0)
			root.right = put(root.right, key, value);
		if(root.key.compareTo(key) > 0)
			root.left = put(root.left, key, value);
		if(root.key.compareTo(key) == 0)
			root.value = value;
		return root;
	}
	
	public Node get(Node root, Key key)
	{
		if(root == null) return null;
		if(root.key.compareTo(key) < 0)
			return get(root.right, key);
		else if(root.key.compareTo(key) > 0)
			return get(root.left, key);
		else
			return root;
	}
	
	public boolean contains(Node root, Key key)
	{
		if(get(root, key) != null) return true;
		return false;
	}
	
	public Node delete(Node root, Key key, Node from)
	{
		if(root == null) return null;
		Node successor = null;
		if(root.key.compareTo(key) < 0)
			root.right = delete(root.right, key, root);
		if(root.key.compareTo(key) > 0)
			root.left = delete(root.left, key, root);
		if(root.key.compareTo(key) == 0)
		{
			successor = min(root.right);
			deleteMin(root.right, root);
			successor.left = root.left;
			successor.right = root.right;
		}
		return successor;
	}

	private void deleteMin(Node right, Node head) {
		Node root = right;
		while(root.left != null)
			deleteMin(root.left, root);
		head.left = root.right;
	}

	private Node min(Node right) {
		Node root = right;
		while(root.left != null)
			min(root.left);
		return root;
	}

	private void printTree() {
		Node root = this.root;
		System.out.println("Root: " + root.key + "<->" + root.value);
		printLeftTree(root.left);
		printRightTree(root.right);
	}

	private Node printRightTree(Node right) {
		if(right != null)
		{
			System.out.println(right.key + "<->" + right.value);
			if(right.left != null)
				right.left = printLeftTree(right.left);
			right.right = printRightTree(right.right);
		}
		return right;
	}

	private Node printLeftTree(Node left) {
		if(left != null)
		{
			System.out.println(left.key + "<->" + left.value);
			if(left.right != null)
				left.right = printLeftTree(left.right);
			left.left = printLeftTree(left.left);
		}
		return left;
	}

	
	public static void main(String[] args) throws Exception
	{
		int a[] = {1,2,5,3,7,8,23,54,6,43,10,55};
		String b[] = {"One", "Two", "Five", "Three", "Seven", "Eight", "Twenty Three", "Fifty Four", "Six", "Forty Three", "Ten", "Fifty Five"};
		BinarySearchTreeDS<Integer, String> bst = new BinarySearchTreeDS<Integer, String>();
		System.out.println("Inserting elements into BST...");
		for(int i=0; i<a.length; i++)
		{
			bst.put(a[i], b[i]);
		}
			
		System.out.println("Printing Tree: ");
		bst.printTree();
		
		System.out.println("Getting value of Key 10 : " + bst.get(10));
		
		System.out.println("Searching if Key 54 exists : " + bst.contains(10));
		
	}

}