package com.euler;

public class LargestPrimeFactor {

	public static void main(String[] args) {
		LargestPrimeFactor lpf = new LargestPrimeFactor();
		System.out.println("Largest Prime Factor: " + lpf.findLargestPrimeFactor(600851475143L));
	}

	private long findLargestPrimeFactor(long n) {
		long i = 0L;
		for(i = 2; i <= n; i++) {
			if(n % i == 0) {
				n = n/i;
				i--;
			}
		}
		return i;
	}

}
