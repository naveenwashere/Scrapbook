
public class NumPalindromeWithRecursion {

	public static void main(String[] args) {
		int num = 1233201;
		NumPalindromeWithRecursion npwr = new NumPalindromeWithRecursion();
		if(npwr.isPalindrome(num)) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}
	}

	private boolean isPalindrome(int num) {
		int numLen = numLength(num);
		return checkIfPalindrome(num, numLen, num);
	}

	private boolean checkIfPalindrome(int num, int numLen, int actual) {
		int len = numLength(num);
		boolean isPal = true;
		if(len != numLen/2) {
			return isPal && checkIfPalindrome(num/10, numLen, actual);
		}
		
		//Get the precise right half of the number
		int exponent = numLength(num);
		int rightHalf = actual % ((int) Math.pow(10, exponent));
		
		int left = num %10;
		int right = rightHalf / ((int) Math.pow(10, exponent-1));
		
		if(left == right) {
			return true;
		} else {
			return false;
		}
	}

	private int numLength(int num) {
		/*int len = 0;
		while(num%10 != 0) {
			len++;
			num = num/10;
		}
		return len;*/
		return (int) Math.log10(num) + 1;
	}

}
