public class FibonacciSeries {

	public void printSeries(int n) {
		int i = 0, j = 1;
		if (n == 0) {
			return;
		} else if (n == 1) {
			System.out.println(i + " " + j);
		} else {
			System.out.print(i + " " + j + " ");
			printNext(i, j, n);
		}
	}

	private void printNext(int i, int j, int n) {
		int sum = i + j;
		i = j;
		j = sum;
		if (sum <= n) {
			System.out.print(sum + " ");
			printNext(i, j, n);
		}
	}
	
	public void fibMethod(int n) {
		for(int i = 0; i < n; i++) {
			System.out.print(printFibNums(i) + " ");
		}
	}
	
	private int printFibNums(int i) {
		if(i == 0) {
			return 0;
		} else if(i == 1) {
			return 1;
		}
		return printFibNums(i-1) + printFibNums(i-2);
	}

	public static void main(String[] args) {
		FibonacciSeries fs = new FibonacciSeries();
		fs.printSeries(10);
		System.out.println();
		fs.fibMethod(10);
	}

}