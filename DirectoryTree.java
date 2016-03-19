import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Node {

	List<Node> childs;
	List<Node> leafs;
	String data;
	String incrementalPath;

	public Node(String nodeValue, String incrementalPath) {
		childs = new ArrayList<Node>();
		leafs = new ArrayList<Node>();
		data = nodeValue;
		this.incrementalPath = incrementalPath;
	}

	public boolean isLeaf() {
		return childs.isEmpty() && leafs.isEmpty();
	}

	public void addElement(String currentPath, String[] list) {

		// Avoid first element that can be an empty string if you split a string
		// that has a starting slash as /sd/card/
		while (list[0] == null || list[0].equals("")) {
			list = Arrays.copyOfRange(list, 1, list.length);
		}

		Node currentChild = new Node(list[0], currentPath + "/" + list[0]);
		if (list.length == 1) {
			leafs.add(currentChild);
			return;
		} else {
			int index = childs.indexOf(currentChild);
			if (index == -1) {
				childs.add(currentChild);
				currentChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
			} else {
				Node nextChild = childs.get(index);
				nextChild.addElement(currentChild.incrementalPath, Arrays.copyOfRange(list, 1, list.length));
			}
		}
	}

	@Override
	public boolean equals(Object obj) {
		Node cmpObj = (Node) obj;
		return incrementalPath.equals(cmpObj.incrementalPath) && data.equals(cmpObj.data);
	}

	public void printNode(int increment) {
		for (int i = 0; i < increment; i++) {
			System.out.print(" ");
		}
		System.out.println(incrementalPath + (isLeaf() ? " -> " + data : ""));
		for (Node n : childs)
			n.printNode(increment + 2);
		for (Node n : leafs)
			n.printNode(increment + 2);
	}

	@Override
	public String toString() {
		return data;
	}

}

public class DirectoryTree {

	Node root;
	Node commonRoot;

	public DirectoryTree(Node root) {
		this.root = root;
		commonRoot = null;
	}

	public void addElement(String elementValue) {
		String[] list = elementValue.split("/");

		// latest element of the list is the filename.extrension
		root.addElement(root.incrementalPath, list);

	}

	public void printTree() {
		// I move the tree common root to the current common root because I
		// don't mind about initial folder
		// that has only 1 child (and no leaf)
		getCommonRoot();
		commonRoot.printNode(0);
	}

	public Node getCommonRoot() {
		if (commonRoot != null)
			return commonRoot;
		else {
			Node current = root;
			while (current.leafs.size() <= 0) {
				current = current.childs.get(0);
			}
			commonRoot = current;
			return commonRoot;
		}

	}

	public static void main(String[] args) {
		String slist[] = new String[] { "/mnt/sdcard/folder1/a/b/file1.file", "/mnt/sdcard/folder1/a/b/file2.file" };

		DirectoryTree tree = new DirectoryTree(new Node("root", "root"));
		for (String data : slist) {
			tree.addElement(data);
		}

		tree.printTree();
	}

}
