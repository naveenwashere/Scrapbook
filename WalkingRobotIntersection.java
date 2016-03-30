import java.util.HashSet;
import java.util.Set;

public class WalkingRobotIntersection {
	
	Set<Node> visitedNodes;
	
	public WalkingRobotIntersection() {
		visitedNodes = new HashSet<Node>();
	}

	class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#hashCode()
		 */
		public int hashCode() {
			return this.x & this.y;
		}

		/*
		 * (non-Javadoc)
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		public boolean equals(Object obj) {
			if (obj instanceof Node) {
				Node otherNode = (Node) obj;
				if(this.x == otherNode.x && this.y == otherNode.y) {
					return true;
				}
			}
			return false;
		}
		
		public String toString() {
			return "("+this.x+", "+this.y+")";
		}
	}
	
	public boolean addNode(Node node) {
		if(node != null) {
			if(visitedNodes.contains(node)) {
				return true;
			}
			this.visitedNodes.add(node);
		}
		return false;
	}
	
	public boolean hasIntersection(String path) {
		if(path.length() == 0) {
			return false;
		}
		this.visitedNodes.clear();
		visitedNodes.add(new Node(0, 0));
		System.out.println(new Node(0, 0).toString());
		
		int left = 0, right = 0, up = 0, down = 0;
		char[] sequences = path.toCharArray();
		
		Node newNode = null;
		for(int i = 0; i < sequences.length; i++) {
			if(sequences[i] == '>') {
				right++;
				newNode = new Node(right - left, up - down);
				System.out.println(newNode.toString());
			}
			if(sequences[i] == '<') {
				left++;
				newNode = new Node(right - left, up - down);
				System.out.println(newNode.toString());
			}
			if(sequences[i] == '^') {
				up++;
				newNode = new Node(right - left, up - down);
				System.out.println(newNode.toString());
			}
			if(sequences[i] == 'v') {
				down++;
				newNode = new Node(right - left, up - down);
				System.out.println(newNode.toString());
			}
			boolean res = this.addNode(newNode);
			if(res) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		WalkingRobotIntersection wri = new WalkingRobotIntersection();
		System.out.println("Intersection found (>>>>>^^<vv)? " + wri.hasIntersection(">>>>>^^<vv"));
		System.out.println("Intersection found (>>>>>^^<v)? " + wri.hasIntersection(">>>>>^^<v"));
		System.out.println("Intersection found (<<>>>>>)? " + wri.hasIntersection("<<>>>>>"));
		System.out.println("Intersection found (^^vv)? " + wri.hasIntersection("^^vv"));
		System.out.println("Intersection found (>>^^<<vv)? " + wri.hasIntersection(">>^^<<vv"));
	}

}
