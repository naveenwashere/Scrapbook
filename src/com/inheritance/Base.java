package com.inheritance;

public class Base implements Comparable<Base> {
	
	int base;
	
	public Base(int a)
	{
		this.base = a;
	}
	
	@Override
	public int compareTo(Base o) {
		System.out.println("In Base to compare " + this.base + " with " + o.base + " to give result as: " + (this.base - o.base));
		return this.base - o.base;
	}

}
