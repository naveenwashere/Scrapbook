package com.codesamples;

/*
 * All three functions below are overloaded functions for the given input.
 * The int is auto upgraded(not sure if its the right wording) to long and
 * the functions with long in its signature will still hold good for the inputs 
 * supplied to the function. So pretty much all functions below are now
 * sort of act like overloaded function for the given input.
 */

class Calculation3 {
	long sum(int a, long b) {
		System.out.println("INT_INT"+ (a + b));
		return a+b;
	}

	long sum(long a, int b) {
		System.out.println("INT_LONG" + (a + b));
		return a+b;
	}
	
	long sum(long a, long b) {
		System.out.println("LONG_LONG" + (a + b));
		return a+b;
	}

	public static void main(String args[]) {
		Calculation3 obj = new Calculation3();
		//System.out.println(obj.sum(20, 20)); // Compile Time Error
	}
}