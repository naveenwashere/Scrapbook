public class PrimeNumbers {

	public void printPrimeNumbersOne(int n) {
		if(n < 1) {
			System.out.println("Enter a number greater than 1!");
		}
		for(int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for(int j = 1; j <= i; j++) {
				//Prime number has only 1 and itself as divisors
				if(i%j == 0 && (j != 1 && j != i)) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void printPrimeNumbersTwo(int n) {
		if(n < 1) {
			System.out.println("Enter a number greater than 1!");
		}
		for(int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for(int j = 1; j <= i/2; j++) {
				//Prime number has only 1 and itself as divisors
				if(i%j == 0 && j != 1) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}
	
	public void primeNumsUsingRecursion(int n) {
		if(n < 1) {
			System.out.println("Enter a number greater than 1!");
		}
		for(int i = 2; i <= n; i++) {
			boolean isPrime = findPrime(i, i/2, 1);
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}
	
	/**
	 * Recursive method to find Prime number
	 * @param i the actual number to determine if prime
	 * @param j the number in decreasing order from i/2 to 1, which forms the divisor
	 * @param k the stopping condition where k == 1
	 * @return true / false based on whether the number is prime or not
	 */
	private boolean findPrime(int i, int j, int k) {
		boolean isPrime = true;
		if(j != k) {
			if(i % j == 0 && (j != 1 && j != i)) {
				isPrime = false;
			}
			return isPrime && findPrime(i, j - 1, k);
		}
		return isPrime;
	}

	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		System.out.println("Prime numbers - Approach One: ");
		pn.printPrimeNumbersOne(100);
		System.out.println("\nPrime numbers - Approach Divided by 2: ");
		pn.printPrimeNumbersTwo(100);
		System.out.println("\nPrime numbers - Approach Recursion: ");
		pn.primeNumsUsingRecursion(100);
	}

}
