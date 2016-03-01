

class DirectoryParser<Key extends Comparable<Key>, Value> {
	
	private class Node {
		Key key;
		Value value;
		Node left, right;
		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
	
	//THE Root
	Node root;
	
	public void put(Key key, Value value) {
		this.root = put(root, key, value);
	}
	
	private Node put(Node root, Key key, Value value) {
		if(root == null) {
			Node newNode = new Node(key, value);
			return newNode;
		} 
		if(root.key.compareTo(key) < 0) {
			root.left = put(root.left, key, value);
		}
		if(root.key.compareTo(key) > 0) {
			root.right = put(root.right, key, value);
		}
		if(root.key.compareTo(key) == 0) {
			root.value = value;
		}
		return root;
	}

	public boolean contains(Key key) {
		if(this.root == null) {
			return false;
		}
		return contains(root, key);
	}

	private boolean contains(Node root, Key key) {
		if(root.key.compareTo(key) < 0) {
			contains(root.left, key);
		}
		if(root.key.compareTo(key) > 0) {
			contains(root.right, key);
		}
		if(root.key.compareTo(key) == 0) {
			return true;
		}
		return false;
	}
	
	private void printTree() {
		Node root = this.root;
		System.out.print("Root: " + root.key + "/");
		printLeftTree(root.left);
		System.out.println();
		printRightTree(root.right);
	}

	private Node printRightTree(Node right) {
		if(right != null)
		{
			System.out.print(right.key + "/");
			if(right.left != null)
				right.left = printLeftTree(right.left);
			right.right = printRightTree(right.right);
		}
		return right;
	}

	private Node printLeftTree(Node left) {
		if(left != null)
		{
			System.out.print(left.key + "/");
			if(left.right != null)
				left.right = printLeftTree(left.right);
			left.left = printLeftTree(left.left);
		}
		return left;
	}
	
	public static void main(String[] args) {
		String slist[] = new String[] { "/mnt/sdcard/folder1/a/b/file1.file", "/mnt/sdcard/folder1/a/b/file2.file",
				"/mnt/sdcard/folder1/a/b/file3.file", "/mnt/sdcard/folder1/a/b/file4.file",
				"/mnt/sdcard/folder1/a/b/file5.file", "/mnt/sdcard/folder1/e/c/file6.file",
				"/mnt/sdcard/folder2/d/file7.file", "/mnt/sdcard/folder2/d/file8.file", "/mnt/sdcard/file9.file" };
		
		DirectoryParser<String, String> dirParser = new DirectoryParser<String, String>();
		
		String root = "/";
		
		dirParser.put(root, root);
	
		for(String path : slist) {
			String[] nodes = path.split("/");
			for(int i = 0; i < nodes.length; i++) {
				if(i == 0) {
					dirParser.put(root, nodes[i]);
				} else {
					dirParser.put(nodes[i-1], nodes[i]);
				}
			}
		}
		
		dirParser.printTree();
	}

}
