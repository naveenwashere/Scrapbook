package com.euler;

public class FibonacciEvenTermsSum {

	private long calculateEvenNumberSum() {
		long sum = 0;
		long fibNum = 0;
		long start = 1;
		while(true) {
			fibNum = getFibNum(start++);
			System.out.print(fibNum + " ");
			if(fibNum %2 == 0) {
				sum += fibNum;
				if(sum > 4000000) {
					break;
				}
			}
		}
		return sum;
	}
	
	private long getFibNum(long i) {
		if(i == 1) {
			return 1;
		}
		if(i == 2) {
			return 2;
		}
		return getFibNum(i-1) + getFibNum(i-2);
	}

	public static void main(String[] args) {
		FibonacciEvenTermsSum fets = new FibonacciEvenTermsSum();
		System.out.println("Sum : " + fets.calculateEvenNumberSum());
	}

}
