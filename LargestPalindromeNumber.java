package com.euler;

/**
 * https://projecteuler.net/problem=4
 * @author naveenkumarkalapati
 *
 */
public class LargestPalindromeNumber {

	public static void main(String[] args) {
		LargestPalindromeNumber lpn = new LargestPalindromeNumber();
		System.out.println(lpn.findLargestPalindromeNumber(999));
	}

	private long findLargestPalindromeNumber(int n) {
		int x = n, y = n;
		int stopAt = n / 10 + 1;
		long product = 0, prevPal = 0;
		while(x >= stopAt && y >= stopAt) {
			product = x * y;
			y--;
			if(y < stopAt) {
				x--;
				y = x;
			} 
			if(isPalindrome(product)) {
				if(product > prevPal) {
					prevPal = product;
				}
			}
		}
		return prevPal;
	}

	private boolean isPalindrome(long product) {
		String actualNum = String.valueOf(product);
		return actualNum.equals(new StringBuilder(actualNum).reverse().toString()); 
	}

}
