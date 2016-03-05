import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class DirectoryParser {
	
	//THE Root
	Node root;
		
	public DirectoryParser(Node root) {
		this.root = root;
	}
	
	public static class Node {
		
		String key;
		List<Node> children;
		List<Node> leaves;
		String incrementalPath;
		
		public Node(String key, String incrementalPath) {
			this.key = key;
			this.children = new ArrayList<Node>();
			this.leaves = new ArrayList<Node>();
			this.incrementalPath = incrementalPath;
		}
		
		public void addChildNode(String incrementalPath, String[] nodes) {
			
			Node currentNode = new Node(nodes[0], incrementalPath + "/" + nodes[0]);
			
			if(nodes.length == 1) {
				this.leaves.add(currentNode);
				return;
			} else {
				int index = this.children.indexOf(currentNode);
				if(index == -1) {
					this.children.add(currentNode);
					currentNode.addChildNode(currentNode.incrementalPath, Arrays.copyOfRange(nodes, 1, nodes.length));
				} else {
					Node existingNode = this.children.get(index);
					existingNode.addChildNode(currentNode.incrementalPath, Arrays.copyOfRange(nodes, 1, nodes.length));
				}
			}
		}
		
		public boolean equals(Object otherNodeObj) {
			if(!(otherNodeObj instanceof Node)) {
				return false;
			}
			Node otherNode = (Node) otherNodeObj;
			if(this.incrementalPath.equals(otherNode.incrementalPath)
					&& this.key.equals(otherNode.key)) {
				return true;
			}
			return false;
		}
		
		private void listDirectories(int increment) {
			for(int i = 0; i < increment; i++) {
				System.out.print(" ");
			}
			
			System.out.println(this.incrementalPath + (isLeaf() ? " -> " + key : ""));
			
			for(Node child : this.children) {
				child.listDirectories(increment + 2);
			}
			for(Node leaf : this.leaves) {
				leaf.listDirectories(increment + 2);
			}
		}

		/**
		 * Node wth no children or leaves is a LEAF node
		 * @return
		 */
		private boolean isLeaf() {
			return this.children.isEmpty() && this.leaves.isEmpty();
		}

	}
	
	public void addDirectoryNode(String directory) {
		if(root == null) {
			return;
		}
		Node rootRef = root;
		String[] nodes = directory.split("/");
		if(nodes != null && nodes.length != 0 && (nodes[0] == null || nodes[0] == "")) {
			nodes = Arrays.copyOfRange(nodes, 1, nodes.length);
		}
		rootRef.addChildNode(rootRef.incrementalPath, nodes);
	}
	
	public void listDirectories() {
		if(root == null) {
			return;
		}
		Node commonRoot = null;
		Node current = root;
		while(current.leaves.size() <= 0) {
			current = current.children.get(0);
		}
		commonRoot = current;
		commonRoot.listDirectories(0);
	}
	
	public static void main(String[] args) {
		String slist[] = new String[] { "/mnt/sdcard/folder1/a/b/file1.file", "/mnt/sdcard/folder1/a/b/file2.file",
				"/mnt/sdcard/folder1/a/b/file3.file", "/mnt/sdcard/folder1/a/b/file4.file",
				"/mnt/sdcard/folder1/a/b/file5.file", "/mnt/sdcard/folder1/e/c/file6.file",
				"/mnt/sdcard/folder2/d/file7.file", "/mnt/sdcard/folder2/d/file8.file", "/mnt/sdcard/file9.file", 
				"/mnt/sdcard/folder1/a/b/file1.file" };
		
		DirectoryParser dirParser = new DirectoryParser(new Node("root", "root"));
		
		for(String path : slist) {
			System.out.println("Requesting to add: " + path);
			dirParser.addDirectoryNode(path);
		}
		
		System.out.println("Listing all directories: \n");
		dirParser.listDirectories();
	}

}
