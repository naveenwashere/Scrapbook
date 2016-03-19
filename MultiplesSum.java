package com.euler;

public class MultiplesSum {

	int multiplesThreeFive(int n) {
		int sum = 0;
		for(int i = 1 ; i < n; i++) {
			if(i % 3 == 0 || i % 5 == 0) {
				sum += i;
				System.out.print(i + " ");
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		MultiplesSum ms = new MultiplesSum();
		System.out.println(" :: Sum " + ms.multiplesThreeFive(10));
		System.out.println(" :: Sum " + ms.multiplesThreeFive(1000));
	}

}
