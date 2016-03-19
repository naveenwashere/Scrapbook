package com.euler;

import java.util.Date;

/**
 * https://projecteuler.net/problem=5
 * @author naveenkumarkalapati
 *
 */
public class SmallestMultiple {

	public static void main(String[] args) {
		SmallestMultiple sm = new SmallestMultiple();
		Date start = new Date();
		sm.findSmallestMultipleBruteForce(20);
		Date end = new Date();
		System.out.println((end.getTime() - start.getTime())/1000 + " seconds");
		
		start = new Date();
		sm.findSmallestMultipleAnotherMinOptimized(20);
		end = new Date();
		System.out.println((end.getTime() - start.getTime())/1000 + " seconds");
		
	}

	/**
	 * Takes 56 seconds
	 * @param till
	 */
	private void findSmallestMultipleBruteForce(int till) {
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
	
	/**
	 * Takes 6 seconds
	 * @param till
	 */
	private void findSmallestMultipleAnotherMinOptimized(int till) {
		boolean found = false;
		long number = 0;
		int counter = 0;
		while(!found) {
			number++;
			for(int i = 1; i <= till; i++) {
				if(number % i != 0) {
					break;
				} else {
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
