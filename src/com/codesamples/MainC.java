package com.codesamples;

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
	}

}
