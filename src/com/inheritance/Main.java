package com.inheritance;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Base base = new Base(10);
		Base de = new Derived(20);
		Derived de2 = new Derived(30);
		Base b = new Base(40);
		
		Comparator<Base> basecomp = new Comparator<Base>() {

			@Override
			public int compare(Base o1, Base o2) {
				System.out.println("In Comparator");
				return o1.base - o2.base;
			}
		};
		
		Set set = new TreeSet(basecomp);
		set.add(base);
		set.add(de);
		set.add(de2);
		set.add(b);
		
		for(Object obj: set)
		{
			System.out.println(((Base)obj).base);
		}
	}

}
