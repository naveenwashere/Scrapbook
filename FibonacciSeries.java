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

	public void printNext(int i, int j, int n) {
		int sum = i + j;
		i = j;
		j = sum;
		if (sum <= n) {
			System.out.print(sum + " ");
			printNext(i, j, n);
		}
	}

	public static void main(String[] args) {
		FibonacciSeries fs = new FibonacciSeries();
		fs.printSeries(10);
	}

}