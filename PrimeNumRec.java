
public class PrimeNumRec {

	public static void main(String[] args) {
		int n = 10;
		PrimeNumRec pnr = new PrimeNumRec();
		System.out.println("Using for loops:");
		pnr.findAllPrimes(n);
		System.out.println("\nUsing recursion:");
		pnr.findAllPrimesUsingRec(n);
	}

	private void findAllPrimesUsingRec(int n) {
		if(n < 1) {
			System.out.println("Enter a number greater than 1");
		}
		
		for(int i = 2; i <= n; i++) {
			boolean isPrime = recAndFindIfPrime(i, 1);
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}

	private boolean recAndFindIfPrime(int i, int j) {
		int stoppingCondn = (int) Math.sqrt(i);
		boolean isPrime = true;
		if(j <= stoppingCondn) {
			isPrime = recAndFindIfPrime(i, j+1);
		}
		
		if(i % j == 0 && (j != 1 && j != i)) {
			return isPrime && false;
		} else {
			return isPrime && true;
		}
	}

	private void findAllPrimes(int n) {
		if(n < 1) {
			System.out.println("Enter a number greater than 1");
		}
		for(int i = 2; i <= n; i++) {
			boolean isPrime = true;
			for(int j = 1; j <= Math.sqrt(i); j++) {
				if(i % j == 0 && j != 1 && i != j) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) {
				System.out.print(i + " ");
			}
		}
	}

}
