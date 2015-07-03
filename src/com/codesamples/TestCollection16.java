package com.codesamples;

import java.util.*;

class TestCollection16 {
	public static void main(String args[]) {

		Hashtable<Integer, String> hm = new Hashtable<Integer, String>();

		hm.put(100, "");
		hm.put(102, "Ravi");
		hm.put(101, "Vijay");
		hm.put(103, "Rahul");

		System.out.println("Print HASHTABLE using an Enumeration:");
		Enumeration<String> e = hm.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		System.out.println("Print HASHTABLE using an Iterator:");
		Iterator<Integer> htItr = hm.keySet().iterator();
		while(htItr.hasNext())
		{
			System.out.println(htItr.next());
		}

		HashMap<Integer, String> ht = new HashMap<Integer, String>();

		ht.put(100, "");
		ht.put(102, "Ravi");
		ht.put(101, "Vijay");
		ht.put(103, "Rahul");
		
		/*System.out.println("Print HASHMAP using an Enumeration:");
		Enumeration<String> ee = ht.elements();
		while (e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}*/
		
		System.out.println("Print HASHMAP using an Iterator:");
		Iterator<Integer> htItrr = ht.keySet().iterator();
		while(htItrr.hasNext())
		{
			System.out.println(htItrr.next());
		}


	}
}
