package com.inheritance;

public class Derived extends Base 
{
	int derived;
	
	public Derived(int a) 
	{
		super(a);
		this.derived = a;
	}

	public int compareTo(Base o) 
	{
		System.out.println("In Derived to compare " + this.derived + " with " + o.base + " to give result as " + (this.derived - o.base));
		return this.derived - o.base;
	}
}
