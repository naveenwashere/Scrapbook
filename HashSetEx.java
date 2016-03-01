import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Vector;

public class HashSetEx {
	int a = 10;
	private HashSetEx() {
		
	}
	public static void main(String args[]) {
		HashSet<String> al = new HashSet<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		al.add(null);

		Iterator<String> itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("--------------");
		LinkedHashSet<String> lhs = new LinkedHashSet<String>();
		lhs.add("Ravi");
		lhs.add("Vijay");
		lhs.add("Ravi");
		lhs.add("Ajay");
		lhs.add(null);

		Iterator<String> itr1 = lhs.iterator();
		while (itr1.hasNext()) {
			System.out.println(itr1.next());
		}

		class Node implements Comparable<Node> {
			int num;

			Node(int num) {
				this.num = num;
			}
			
			public int compareTo(Node node) {
				if(this.num < node.num) return -1;
				if(this.num > node.num) return 1;
				return 0;
			}
			
			public String toString() {
				return String.valueOf(num);
			}
		}

		System.out.println("--------------");
		TreeSet<Node> ts = new TreeSet<Node>();
		ts.add(new Node(5));
		ts.add(new Node(6));
		ts.add(new Node(1));
		ts.add(new Node(2));
		
		Iterator<Node> itr11 = ts.iterator();
		while (itr11.hasNext()) {
			Node node = itr11.next();
			System.out.println(node.num);
		}
		
		System.out.println("--------------");
		HashMap<Node, Node> hm = new HashMap<Node, Node>();
		hm.put(new Node(5), new Node(5));
		hm.put(new Node(6), new Node(6));
		hm.put(new Node(1), new Node(1));
		hm.put(new Node(2), new Node(2));

		System.out.println(hm.entrySet());

		Vector<String> v = new Vector<String>();// creating vector
		v.add("umesh");// method of Collection
		v.addElement("irfan");// method of Vector
		v.addElement("kumar");
		// traversing elements using Enumeration
		Enumeration<String> e = v.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
			//v.addElement("kumar"); //Not fail-fast Modifies source that's being read
		}
		
		//Reflection: How to break SINGLETON
		HashSetEx ex = new HashSetEx();
		Constructor[] ctors = ex.getClass().getDeclaredConstructors();
		Constructor ctor = null;
		for (int i = 0; i < ctors.length; i++) {
		    ctor = ctors[i];
		    if (ctor.getGenericParameterTypes().length == 0)
			break;
		}

		try {
		    ctor.setAccessible(true);
		    HashSetEx c = (HashSetEx)ctor.newInstance();
		    System.out.println(c.getClass());
		    System.out.println(ex.a + " -> " + c.a + " -> Class.newInstance() -> " + ex.getClass().newInstance().a);
	 	    System.out.println(ex.hashCode() + " -> " + c.hashCode() + " -> Class.newInstance() -> " + ex.getClass().newInstance().hashCode());
		} catch (InstantiationException x) {
		    x.printStackTrace();
	 	} catch (InvocationTargetException x) {
	 	    x.printStackTrace();
		} catch (IllegalAccessException x) {
		    x.printStackTrace();
		}
	}
}
