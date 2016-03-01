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
	
	public static void main(String[] args) {
		PrimeNumbers pn = new PrimeNumbers();
		System.out.println("Prime numbers - Approach One: ");
		pn.printPrimeNumbersOne(100);
		System.out.println("\nPrime numbers - Approach Divided by 2: ");
		pn.printPrimeNumbersTwo(100);
	}

}
