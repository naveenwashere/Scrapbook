package com.codesamples;

public class B extends A {

	public int a = 20;
	
	public int getBA()
	{
		return a;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		B b = new B();
		A a = new B();
		System.out.println("B Obj = " + b.a);
	}

}
