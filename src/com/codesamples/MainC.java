package com.codesamples;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MainC extends AbstractA implements InterfaceB {

	public void testMethod() {
		//System.out.println("Value of A: " + a);
		System.out.println("MainC");
	}
	
	public void mainCMethod()
	{
		System.out.println("I exist only in MainC");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainC objC = new MainC();
		InterfaceB intB = new MainC();
		AbstractA abA = new MainC();
		objC.testMethod();
		intB.testMethod();
		abA.testMethod();
		
		Set<String> str = new HashSet<String>();
		str.add("null");
		str.add("not null");
		
		/*for(String s : str)
		{
			System.out.println(s);
		}*/
		
		System.out.println("Before remove");
		
		Iterator itr = str.iterator();
		while(itr.hasNext())
		{
			itr.next();
			//Can do remove only after calling next()
			itr.remove();
			str.add("inter");
		}
		
		System.out.println("Removed \n\n");
		
		for(String s : str)
		{
			System.out.println(s);
		}
	}

}
