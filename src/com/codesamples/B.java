package com.codesamples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class B extends A {

	public int a = 20;
	
	public int getBA()
	{
		return a;
	}
	
	class W implements Comparable<W>
	{
		String name;
		int roll;
		public W(String name, int roll)
		{
			this.name = name;
			this.roll = roll;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public int getRoll()
		{
			return this.roll;
		}
		
		public int compareTo(W w)
		{
			return this.name.compareTo(w.getName());
		}

	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B();
		A a = new B();
		System.out.println("B Obj = " + b.a);
		
		List<W> list = new ArrayList<W>();
		list.add(b.new W("Naveen", 10));
		list.add(b.new W("Kumar", 20));
		list.add(b.new W("Kalapati", 30));
		
		
		
		for(W w : list)
		{
			System.out.println(w.getName() + " - " + w.getRoll());
		}
		
		System.out.println("After Collections.sort");
		
		Collections.sort(list);
		
		for(W w : list)
		{
			System.out.println(w.getName() + " - " + w.getRoll());
		}
		
		Collections.sort(list, new Comparator<W>(){

			@Override
			public int compare(W o1, W o2) {
				return o1.getRoll() - o2.getRoll();
			}
			
		});
		
		System.out.println("After comparator");
			
		for(W w : list)
		{
			System.out.println(w.getName() + " - " + w.getRoll());
		}
	}

}
