package com.euler;

/**
 * https://projecteuler.net/problem=5
 * @author naveenkumarkalapati
 *
 */
public class SmallestMultiple {

	public static void main(String[] args) {
		SmallestMultiple sm = new SmallestMultiple();
		sm.findSmallestMultiple(20);
	}

	private void findSmallestMultiple(int till) {
		boolean found = false;
		long number = 0;
		int counter = 0;
		while(!found) {
			number++;
			for(int i = 1; i <= till; i++) {
				if(number % i == 0) {
					counter++;
				}
			}
			if(counter == till) {
				found = true;
				break;
			} else {
				counter = 0;
			}
		}
		System.out.println(number);
	}

}
