
public class ReverseNumberRecursion {

	public static void main(String[] args) {
		int num = 123;
		ReverseNumberRecursion rnr = new ReverseNumberRecursion();
		System.out.println(rnr.reverseNumber(num));
	}

	private int reverseNumber(int num) {
		int lenOfNum = numLength(num);
		if(lenOfNum == 1) {
			return num;
		}
		
		int runningSum = (int) ((num % 10) * Math.pow(10, lenOfNum-1));
		
		return runningSum + reverseNumber(num/10);
	}

	private int numLength(int num) {
		int len = 0;
		while(num % 10 != 0) {
			len++;
			num = num/10;
		}
		return len;
	}

}
