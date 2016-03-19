package com.euler;

import java.util.Date;

public class NthPrimeNumber {

	public static void main(String[] args) {
		NthPrimeNumber nthPrime = new NthPrimeNumber();
		Date start = new Date();
		System.out.println(nthPrime.findNthPrime(10001));
		System.out.println("Time: " + (new Date().getTime() - start.getTime()));
	}

	private int findNthPrime(int n) {
		int counter = 0;
		int number = 1;
		boolean isPrime = true;
		while(counter != n) {
			isPrime = true;
			number++;
			for(int i = 1; i <= Math.sqrt(number); i++) {
				if(number % i == 0 && i != 1) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.println(number + " ");
				counter++;
			}
		}
		System.out.println();
		return number;
	}

}
